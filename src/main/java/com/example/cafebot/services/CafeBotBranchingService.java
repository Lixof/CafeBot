package com.example.cafebot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
@RequiredArgsConstructor
public class CafeBotBranchingService {

    private final CafeBotResponseServices cafeBotResponseServices;

    public void myLocation(SendMessage message) {

        message.setText("Рядом с вами");
        cafeBotResponseServices.response(message);
    }

    public void addresLocation(SendMessage message) {

        message.setText("Введите адрес");
        cafeBotResponseServices.response(message);
    }

//    public void addres(SendMessage message) {
//
//        message.setText("Адрес введен");
//        cafeBotResponseServices.response(message);
//    }

    public void loved(SendMessage message) {

        message.setText("Ваши любимые");
        cafeBotResponseServices.response(message);
    }

    public void topWeek(SendMessage message) {

        message.setText("Топ недели");
        cafeBotResponseServices.response(message);
    }

    public void random(SendMessage message) {

        message.setText("Воспользуйтесь встроенной клавиатурой");
        cafeBotResponseServices.response(message);
    }
}
