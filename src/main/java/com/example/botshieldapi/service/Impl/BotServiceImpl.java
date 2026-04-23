package com.example.botshieldapi.service.Impl;

import com.example.botshieldapi.dto.requests.BotRequest;
import com.example.botshieldapi.dto.response.BotResponse;
import com.example.botshieldapi.entity.Bot;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import com.example.botshieldapi.mappers.BotMapper;
import org.springframework.stereotype.Service;
import com.example.botshieldapi.repository.BotRepository;
import com.example.botshieldapi.service.BotService;

import java.time.LocalDateTime;
@Service
@AllArgsConstructor
@Transactional
public class BotServiceImpl implements BotService {
BotRepository botRepository;
    @Override
    public BotResponse registerUser(BotRequest botRequest) {
        Bot bot=new Bot();
        bot.setBotName(botRequest.getBotName());
        bot.setPersonalDescription(botRequest.getPersonalDescription());
        bot.setCreatedAt(LocalDateTime.now());
        botRepository.save(bot);
        return BotMapper.mapToBotResponse(botRepository.save(bot));
    }
}
