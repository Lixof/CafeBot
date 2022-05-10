package com.example.cafebot.bots;

import com.example.cafebot.services.ResponseInterface;
import com.example.cafebot.services.MessageInterface;
import com.example.cafebot.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CafeBot extends TelegramLongPollingBot {

    private final MessageInterface messageInterface;
    private final ResponseInterface responseInterface;
    private final TelegramBotsApi telegramBotsApi;
    private final LocationService locationService;

    @PostConstruct
    private void postConstruct() throws Exception{

        responseInterface.setCafeBot(this);
        telegramBotsApi.registerBot(this);
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
        SendPhoto sendPhoto = new SendPhoto();
        SendLocation sendLocation = new SendLocation();
        message.setChatId(update.getMessage().getChatId().toString());
        sendPhoto.setChatId(message.getChatId());
        sendLocation.setChatId(message.getChatId());

        if (update.getMessage().getLocation() != null) {
            locationService.process(sendPhoto, sendLocation, update);
            return;
        }

        switch (Optional.ofNullable(update.getMessage().getText()).orElse("")) {
            case "Рядом с адресом" :
                messageInterface.addressLocation(message, update);
                break;
            case "Любимые" :
                messageInterface.loved(message, update);
                break;
            case "Топ недели" :
                messageInterface.topWeek(message, update);
                break;
            default:
                messageInterface.random(message, update);
        }
    }
}