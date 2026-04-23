package com.example.botshieldapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private Long postId;
    private Long userId;
    private Long botId;
    private String content;
    private int depthLevel;
    private Long parentCommentId;
    private LocalDateTime createdAt;
}
