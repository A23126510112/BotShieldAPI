package com.example.botshieldapi.service;

import com.example.botshieldapi.dto.requests.BotRequest;
import com.example.botshieldapi.dto.response.BotResponse;

public interface BotService {
    public BotResponse registerUser(BotRequest botRequest);
}
