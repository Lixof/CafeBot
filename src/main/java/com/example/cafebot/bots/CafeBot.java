package com.example.cafebot.bots;

import com.example.cafebot.services.KeyboardInterface;
import com.example.cafebot.services.MessageInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.pinnedmessages.UnpinChatMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMemberOwner;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CafeBot extends TelegramLongPollingBot {

    private final MessageInterface messageInterface;
    private final KeyboardInterface keyboardInterface;

    @PostConstruct
    private void postConstruct() {
        keyboardInterface.setCafeBot(this);
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

        switch (Optional.ofNullable(update.getMessage().getText()).orElse("")) {
            case "Рядом со мной" :
                messageInterface.myLocation(message, update);
                break;
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