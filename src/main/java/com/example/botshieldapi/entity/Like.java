package com.example.botshieldapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "likes",
        indexes = {
                @Index(name = "idx_post_user", columnList = "postId,userId")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_post_user", columnNames = {"postId", "userId"})
        }
)
@Getter
@Setter

public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long postId;
    private Long userId;
    private LocalDateTime createdAt;
}
