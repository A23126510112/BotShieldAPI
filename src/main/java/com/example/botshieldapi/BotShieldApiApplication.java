package com.example.botshieldapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication

public class BotShieldApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotShieldApiApplication.class, args);
    }

}
