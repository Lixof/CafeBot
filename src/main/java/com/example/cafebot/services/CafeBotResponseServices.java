package com.example.cafebot.services;

import com.example.cafebot.bots.CafeBot;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CafeBotResponseServices {

    private CafeBot cafeBot;

    public void response(SendMessage message) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Рядом со мной");
        row.add("Рядом с адресом");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("Любимые");
        row.add("Топ недели");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);

        try {
            cafeBot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
