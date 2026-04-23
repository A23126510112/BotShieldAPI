package com.example.botshieldapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BotResponse {
    private Long botId;
    private String botName;
    private String personalDescription;
    private LocalDateTime createdAt;
}
