package com.example.botshieldapi.service.Impl;

import com.example.botshieldapi.dto.requests.LikeRequest;
import com.example.botshieldapi.dto.response.LikeResponse;
import com.example.botshieldapi.entity.Like;
import com.example.botshieldapi.exception.ResourceNotFoundException;
import com.example.botshieldapi.repository.PostRepository;
import com.example.botshieldapi.repository.UserRepository;
import com.example.botshieldapi.service.RedisService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.example.botshieldapi.repository.LikeRepository;
import com.example.botshieldapi.service.LikeService;

import java.time.LocalDateTime;
@Service
@AllArgsConstructor
@Transactional
public class LikeServiceImpl implements LikeService {
    LikeRepository likeRepository;
    PostRepository postRepository;
    UserRepository userRepository;
   RedisService redisService;

    @Override
    public LikeResponse likeAPost(Long postId,LikeRequest likeRequest) {
        Like newLike = new Like();
        userRepository.findById(likeRequest.getUserId()).orElseThrow(()->new ResourceNotFoundException(" User not found"));
      postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found"));
      if(likeRepository.existsByPostIdAndUserId(postId,likeRequest.getUserId())){
          throw new RuntimeException("User already liked this post");
      }
            newLike.setPostId(postId);
          newLike.setUserId(likeRequest.getUserId());
          newLike.setCreatedAt(LocalDateTime.now());
          //Redis Updated here
          String key="post:"+postId+":virality_score";
          redisService.increment(key,20);
          likeRepository.save(newLike);
          return new LikeResponse(postId, likeRepository.countByPostId(newLike.getPostId()));

    }

    @Override
    public int likesCount(Long postId) {
        return likeRepository.countByPostId(postId);
    }

}
