package com.example.botshieldapi.service.Impl;

import com.example.botshieldapi.dto.requests.PostRequest;
import com.example.botshieldapi.dto.response.CommentResponse;
import com.example.botshieldapi.dto.response.PostResponse;
import com.example.botshieldapi.entity.Comment;
import com.example.botshieldapi.entity.Post;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import com.example.botshieldapi.mappers.CommentMapper;
import com.example.botshieldapi.mappers.PostMapper;
import org.springframework.stereotype.Service;
import com.example.botshieldapi.repository.CommentRepository;
import com.example.botshieldapi.repository.PostRepository;
import com.example.botshieldapi.service.PostService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
    PostRepository postRepository;
    CommentRepository commentRepository;
    @Override
    public PostResponse postPost(PostRequest request) {
        Post newPost=new Post();
        newPost.setUserId(request.getUserId());
        newPost.setContent(request.getContent());
        newPost.setBotId(request.getBotId());
        newPost.setCreated(LocalDateTime.now());
        postRepository.save(newPost);
        return  PostMapper.mapToPostResponse(newPost);
    }

    @Override
    public List<CommentResponse> getAllComments(Long postId) {
        List<Comment> comments=commentRepository.findAllByPostId(postId);
        return comments.stream().map(CommentMapper::mapToCommentResponse).collect(Collectors.toList());
    }

}
