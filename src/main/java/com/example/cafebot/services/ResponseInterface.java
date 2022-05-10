package com.example.cafebot.services;

import com.example.cafebot.bots.CafeBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public interface ResponseInterface {

    void defaultResponse(SendMessage message);
    void response(SendMessage message, List<KeyboardRow> keyboard);
    void defaultResponse(SendPhoto photo);
    void response(SendPhoto photo, List<KeyboardRow> keyboard);
    void defaultResponse(SendLocation location);
    void response(SendLocation location, List<KeyboardRow> keyboard);
    void setCafeBot(CafeBot cafeBot);
}
