package com.luis.openai.app.service;

import com.luis.openai.app.model.request.BotRequest;
import com.luis.openai.app.model.response.ChatGptResponse;

public interface BotService {

    ChatGptResponse askQuestion(BotRequest botRequest);
}
