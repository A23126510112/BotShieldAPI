package com.example.botshieldapi.dto.requests;

import lombok.Getter;

@Getter
public class PostRequest {
    private Long userId;
    private Long botId;
    private String content;
}
