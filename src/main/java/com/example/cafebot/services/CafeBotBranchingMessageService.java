package com.example.cafebot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class CafeBotBranchingMessageService implements MessageInterface {

    private final ResponseInterface responseInterface;

    public void addressLocation(SendMessage message, Update update) {

        message.setText("Введите адрес");
        responseInterface.defaultResponse(message);
    }

    public void loved(SendMessage message, Update update) {

        message.setText("Ваши любимые");
        responseInterface.defaultResponse(message);
    }

    public void topWeek(SendMessage message, Update update) {

        message.setText("Топ недели");
        responseInterface.defaultResponse(message);
    }

    public void random(SendMessage message, Update update) {

        message.setText("Воспользуйтесь встроенной клавиатурой");
        responseInterface.defaultResponse(message);
    }
}
