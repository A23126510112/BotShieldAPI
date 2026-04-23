package com.example.botshieldapi.mappers;

import com.example.botshieldapi.dto.response.BotResponse;
import com.example.botshieldapi.entity.Bot;

public class BotMapper {
    public static BotResponse mapToBotResponse(Bot bot) {
        BotResponse botResponse = new BotResponse();
        botResponse.setBotId(bot.getId());
        botResponse.setBotName(bot.getBotName());
        botResponse.setPersonalDescription(bot.getPersonalDescription());
        botResponse.setCreatedAt(bot.getCreatedAt());
        return botResponse;
    }
}
