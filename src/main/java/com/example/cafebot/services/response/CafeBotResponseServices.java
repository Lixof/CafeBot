package com.example.cafebot.services.response;

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

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CafeBotResponseServices implements ResponseInterface {

    private ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
    private CafeBot cafeBot;

    public ResponseInterface response(SendMessage message) {

        message.setReplyMarkup(keyboardMarkup);

        try {
            cafeBot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return this;
    }

    public ResponseInterface response(SendPhoto photo) {

        photo.setReplyMarkup(keyboardMarkup);

        try {
            cafeBot.execute(photo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return this;
    }

    public ResponseInterface response(SendLocation location) {

        location.setReplyMarkup(keyboardMarkup);

        try {
            cafeBot.execute(location);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return this;
    }

    @PostConstruct
    private void postConstruct() {

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(KeyboardButton.builder().text("Рядом со мной").requestLocation(true).build());
        row.add("Рядом с адресом");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("Топ недели");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
    }
}
