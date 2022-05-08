package com.example.cafebot.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface MessageInterface {

    void myLocation(SendMessage message, Update update);
    void addressLocation(SendMessage message, Update update);
    void loved(SendMessage message, Update update);
    void topWeek(SendMessage message, Update update);
    void random(SendMessage message, Update update);
}
