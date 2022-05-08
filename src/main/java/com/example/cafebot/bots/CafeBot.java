package com.example.cafebot.bots;

import com.example.cafebot.services.CafeBotBranchingService;
import com.example.cafebot.services.CafeBotResponseServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class CafeBot extends TelegramLongPollingBot {

    private final CafeBotBranchingService cafeBotBranchingService;
    private final CafeBotResponseServices cafeBotResponseServices;

    @PostConstruct
    private void postConstruct() {
        cafeBotResponseServices.setCafeBot(this);
    }

    @Value("${bot.name}")
    private String NAME;
    @Value("${bot.token}")
    private String TOKEN;

    @Override
    public String getBotUsername() {
        return NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());

        switch (update.getMessage().getText()) {
            case "Рядом со мной" :
                cafeBotBranchingService.myLocation(message);
                break;
            case "Рядом с адресом" :
                cafeBotBranchingService.addresLocation(message);
                break;
            case "Любимые" :
                cafeBotBranchingService.loved(message);
                break;
            case "Топ недели" :
                cafeBotBranchingService.topWeek(message);
                break;
            default:
                cafeBotBranchingService.random(message);
        }
    }
}
