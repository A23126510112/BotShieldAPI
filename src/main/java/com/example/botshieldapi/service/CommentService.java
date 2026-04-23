package com.example.botshieldapi.service;

import com.example.botshieldapi.dto.requests.CommentRequest;
import com.example.botshieldapi.dto.response.CommentResponse;

public interface CommentService {
    public CommentResponse commentPost(Long pstId, CommentRequest commentRequest);

}
