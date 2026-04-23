package com.example.botshieldapi.controllers;

import com.example.botshieldapi.dto.requests.BotRequest;
import com.example.botshieldapi.dto.response.BotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.botshieldapi.service.BotService;
    @RestController
    @RequestMapping("/api/bots")
    public class BotController {
        @Autowired
        BotService botService;
        @PostMapping
        public ResponseEntity<BotResponse> registerUser(@RequestBody BotRequest botRequest) {
            return ResponseEntity.ok(botService.registerUser(botRequest));
        }
    }