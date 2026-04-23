package com.example.botshieldapi.service;

import com.example.botshieldapi.dto.requests.PostRequest;
import com.example.botshieldapi.dto.response.CommentResponse;
import com.example.botshieldapi.dto.response.PostResponse;

import java.util.List;

public interface PostService {
    public PostResponse postPost(PostRequest postRequest);
    public List<CommentResponse> getAllComments(Long postId);
}
