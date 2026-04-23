package com.example.botshieldapi.repository;

import com.example.botshieldapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
