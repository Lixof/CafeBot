package com.example.cafebot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class CafeBotBranchingMessageService implements MessageInterface {

    private final CafeBotKeyboardServices cafeBotKeyboardServices;

    public void myLocation(SendMessage message, Update update) {

        message.setText("Рядом с вами");
        cafeBotKeyboardServices.defaultResponse(message);
    }

    public void addressLocation(SendMessage message, Update update) {

        message.setText("Введите адрес");
        cafeBotKeyboardServices.defaultResponse(message);
    }

    public void loved(SendMessage message, Update update) {

        message.setText("Ваши любимые");
        cafeBotKeyboardServices.defaultResponse(message);
    }

    public void topWeek(SendMessage message, Update update) {

        message.setText("Топ недели");
        cafeBotKeyboardServices.defaultResponse(message);
    }

    public void random(SendMessage message, Update update) {

//        switch (update.getChatJoinRequest())

        message.setText("Воспользуйтесь встроенной клавиатурой");
        cafeBotKeyboardServices.defaultResponse(message);
    }
}
