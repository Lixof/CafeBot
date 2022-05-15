package com.example.cafebot.bots;

import com.example.cafebot.persistence.cafe.CafeMap;
import com.example.cafebot.persistence.top.TopMap;
import com.example.cafebot.services.branching.*;
import com.example.cafebot.services.response.ResponseInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CafeBot extends TelegramLongPollingBot {

    private final ResponseInterface responseInterface;
    private final TelegramBotsApi telegramBotsApi;

    private final CafeMap cafeMap;
    private final TopMap topMap;

    private final LocationService locationService;
    private final AllService allService;
    private final TopWeekService topWeekService;
    private final AddressService addressService;
    private final DefaultService defaultService;
    private final IdService idService;

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

        String chatId = update.getMessage().getChatId().toString();

        if (update.getMessage().getLocation() != null) {
            locationService.process(chatId, update);
            return;
        }

        String mes = Optional.ofNullable(update.getMessage().getText()).orElse("");

        switch (mes) {
            case "LnpQ1" :
                allService.process(chatId);
                break;
            case "hXB2t" :
                cafeMap.process();
                break;
            case "Cg7Fd" :
                topMap.process();
                break;
            case "Рядом с адресом" :
                addressService.process(chatId);
                break;
            case "Топ недели" :
                topWeekService.process(chatId);
                break;
            default:
                defaultService.process(chatId);
        }

        String[] id = mes.split(" ");
        if (id[0].equals("id")) {
            try {
                idService.process(chatId, Long.parseLong(id[1]));
            } catch (Exception e ) { e.printStackTrace(); }
        }
    }
}