package com.example.botshieldapi.repository;

import com.example.botshieldapi.entity.Bot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotRepository extends JpaRepository<Bot,Long> {
}
