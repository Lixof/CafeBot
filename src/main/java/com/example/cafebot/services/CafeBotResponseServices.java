package com.example.cafebot.services;

import com.example.cafebot.bots.CafeBot;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CafeBotResponseServices implements ResponseInterface {

    private CafeBot cafeBot;

    public void defaultResponse(SendMessage message) {

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton myLocationButton = KeyboardButton.builder().text("Рядом со мной").requestLocation(true).build();
        row.add(myLocationButton);
        row.add("Рядом с адресом");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("Любимые");
        row.add("Топ недели");
        keyboard.add(row);

        this.response(message, keyboard);
    }

    public void response(SendMessage message, List<KeyboardRow> keyboard) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);

        try {
            cafeBot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void defaultResponse(SendPhoto photo) {

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton myLocationButton = KeyboardButton.builder().text("Рядом со мной").requestLocation(true).build();
        row.add(myLocationButton);
        row.add("Рядом с адресом");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("Любимые");
        row.add("Топ недели");
        keyboard.add(row);

        this.response(photo, keyboard);
    }

    public void response(SendPhoto photo, List<KeyboardRow> keyboard) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboard);
        photo.setReplyMarkup(keyboardMarkup);

        try {
            cafeBot.execute(photo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void defaultResponse(SendLocation location) {

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton myLocationButton = KeyboardButton.builder().text("Рядом со мной").requestLocation(true).build();
        row.add(myLocationButton);
        row.add("Рядом с адресом");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("Любимые");
        row.add("Топ недели");
        keyboard.add(row);

        this.response(location, keyboard);
    }

    public void response(SendLocation location, List<KeyboardRow> keyboard) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboard);
        location.setReplyMarkup(keyboardMarkup);

        try {
            cafeBot.execute(location);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
