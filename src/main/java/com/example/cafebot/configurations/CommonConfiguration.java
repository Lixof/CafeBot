package com.example.cafebot.configurations;

import com.example.cafebot.bots.CafeBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class CommonConfiguration {

    @Value("${bot.name}")
    private String NAME;
    @Value("${bot.token}")
    private String TOKEN;

    @Bean
    public TelegramBotsApi telegramBotsApi() throws Exception{
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new CafeBot(NAME, TOKEN));
        return telegramBotsApi;
    }
}
