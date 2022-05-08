package com.example.cafebot.services;

import com.example.cafebot.bots.CafeBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public interface KeyboardInterface {

    void defaultResponse(SendMessage message);
    void response(SendMessage message, List<KeyboardRow> keyboard);
    void setCafeBot(CafeBot cafeBot);
}
