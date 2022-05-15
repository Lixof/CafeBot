package com.example.cafebot.services.branching;

import com.example.cafebot.services.response.ResponseInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
@RequiredArgsConstructor
public class DefaultService {

    private final ResponseInterface responseInterface;

    public void process(String chatId) {

        responseInterface.response(SendMessage.builder().chatId(chatId).text("Воспользуйтесь встроенной клавиатурой").build());
    }
}
