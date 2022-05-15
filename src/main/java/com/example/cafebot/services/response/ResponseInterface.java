package com.example.cafebot.services.response;

import com.example.cafebot.bots.CafeBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
public interface ResponseInterface {

    ResponseInterface response(SendMessage message);
    ResponseInterface response(SendPhoto photo);
    ResponseInterface response(SendLocation location);
    void setCafeBot(CafeBot cafeBot);
}
