package com.example.botshieldapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
    private Long id;
    private String content;
    private Long botId;
    private Long userId;
    private LocalDateTime createdAt;

}
