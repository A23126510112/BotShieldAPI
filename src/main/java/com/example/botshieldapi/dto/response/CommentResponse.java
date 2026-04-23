package com.example.botshieldapi.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CommentResponse {
    private Long id;
    private Long postId;
    private String content;
    private int depthLevel;
    private Long userId;
    private Long botId;
    private Long parentCommentId;
    private LocalDateTime createdAt;
}
