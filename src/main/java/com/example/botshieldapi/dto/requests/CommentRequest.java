package com.example.botshieldapi.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentRequest {
    private Long userId;
    private Long botId;
    private String content;
    private Long parentCommentId;
}
