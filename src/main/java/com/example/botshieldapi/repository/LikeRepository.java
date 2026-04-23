package com.example.botshieldapi.repository;

import com.example.botshieldapi.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    int countByPostId(Long postId);

    boolean existsByPostIdAndUserId(Long postId, Long userId);
}
