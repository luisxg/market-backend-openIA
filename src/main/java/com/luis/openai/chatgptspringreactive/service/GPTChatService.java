package com.luis.openai.chatgptspringreactive.service;

import org.mvnsearch.chatgpt.model.ChatCompletion;
import org.mvnsearch.chatgpt.model.GPTExchange;
import reactor.core.publisher.Mono;

@GPTExchange
public interface GPTChatService {

    @ChatCompletion("Eres un vendedor experto, da los ingredientes necesarios para realizar la comida que te pidan," +
            " cada ingrediente separalo por ; y los nombres mas comunes que existen. El plato a preparar es {0}")
    Mono<String> getPrompt(String prompt);
}
