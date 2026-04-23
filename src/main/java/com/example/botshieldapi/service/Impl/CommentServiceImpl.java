package com.example.botshieldapi.service.Impl;

import com.example.botshieldapi.dto.requests.CommentRequest;
import com.example.botshieldapi.dto.response.CommentResponse;
import com.example.botshieldapi.entity.Comment;
import com.example.botshieldapi.exception.ResourceNotFoundException;
import com.example.botshieldapi.mappers.CommentMapper;
import com.example.botshieldapi.repository.*;
import com.example.botshieldapi.service.CommentService;
import com.example.botshieldapi.service.RedisService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    PostRepository postRepository;
    CommentRepository commentRepository;
    UserRepository userRepository;
    BotRepository botRepository;
    RedisService redisService;

    @Override
    public CommentResponse commentPost(Long postId, CommentRequest commentRequest) {

        int depth=1;
        Long userId=commentRequest.getUserId();
        Long botId=commentRequest.getBotId();

        if(userId==null && botId==null){
            throw new RuntimeException("Either userId or botId must be provided");
        }
        if(userId!=null && botId!=null){
            throw new RuntimeException("Only one of userId or botId allowed");
        }

        if(userId!=null){
            userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
        }
        if(botId!=null){
            botRepository.findById(botId).orElseThrow(()->new ResourceNotFoundException("Bot not found"));
        }

        postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found"));

        Comment parent=null;
        if(commentRequest.getParentCommentId()!=null){
            parent=commentRepository.findById(commentRequest.getParentCommentId())
                    .orElseThrow(()->new ResourceNotFoundException("Parent comment not found"));
            depth=parent.getDepthLevel()+1;
        }

        if(depth>20){
            throw new RuntimeException("Max depth exceeded");
        }

        if(botId!=null && parent!=null && parent.getUserId()!=null){

            Long targetUserId=parent.getUserId();

            String cooldownKey="cooldown:bot_"+botId+":user_"+targetUserId;
            if(redisService.hasKey(cooldownKey)){
                throw new RuntimeException("Bot is in cooldown");
            }

            String countKey="post:"+postId+":bot_reply_count";
            long count=redisService.get(countKey);
            if(count>=100){
                throw new RuntimeException("Bot reply limit reached for this post");
            }
        }

        Comment comment=new Comment();
        comment.setPostId(postId);
        comment.setUserId(userId);
        comment.setBotId(botId);
        comment.setContent(commentRequest.getContent());
        comment.setParentCommentId(commentRequest.getParentCommentId());
        comment.setDepthLevel(depth);
        comment.setCreatedAt(LocalDateTime.now());

        commentRepository.save(comment);

        String viralityKey="post:"+postId+":virality_score";

        if(userId!=null){
            redisService.increment(viralityKey,50);
        }else{
            redisService.increment(viralityKey,1);
            redisService.increment("post:"+postId+":bot_reply_count",1);

            if(parent!=null && parent.getUserId()!=null){
                String cooldownKey="cooldown:bot_"+botId+":user_"+parent.getUserId();
                redisService.setWithTTL(cooldownKey,"1", Duration.ofMinutes(15));
            }
        }

        return CommentMapper.mapToCommentResponse(comment);
    }
}