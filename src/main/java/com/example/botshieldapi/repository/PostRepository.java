package com.example.botshieldapi.repository;

import com.example.botshieldapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByUserId(Long userId);
}
