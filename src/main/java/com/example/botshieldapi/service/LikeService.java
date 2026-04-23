package com.example.botshieldapi.service;

import com.example.botshieldapi.dto.requests.LikeRequest;
import com.example.botshieldapi.dto.response.LikeResponse;

public interface LikeService {
    public LikeResponse likeAPost(Long postId,LikeRequest likeRequest);
    public int likesCount(Long postId);
}
