package com.example.cafebot.configurations;

import com.example.cafebot.bots.CafeBot;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@RequiredArgsConstructor
public class CommonConfiguration {

    private final CafeBot cafeBot;

    @Bean
    public TelegramBotsApi telegramBotsApi() throws Exception{
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(cafeBot);
        return telegramBotsApi;
    }
}
