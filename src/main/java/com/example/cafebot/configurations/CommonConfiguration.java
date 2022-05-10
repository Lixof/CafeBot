package com.example.cafebot.configurations;

import com.example.cafebot.bots.CafeBot;
import lombok.RequiredArgsConstructor;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@EnableScheduling
public class CommonConfiguration {

    @Value("${datasource.url}")
    private String dbUrl;

    @Value("${datasource.username}")
    private String dbUserName;

    @Value("${datasource.password}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL(dbUrl);
        dataSource.setUser(dbUserName);
        dataSource.setPassword(dbPassword);

        return dataSource;
    }

    @Bean
    public TelegramBotsApi telegramBotsApi() throws Exception{
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        return telegramBotsApi;
    }
}
