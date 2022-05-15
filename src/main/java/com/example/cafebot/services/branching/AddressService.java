package com.example.cafebot.services.branching;

import com.example.cafebot.services.response.ResponseInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final ResponseInterface responseInterface;

    public void process(String chatId) {

        responseInterface.response(SendPhoto.builder().chatId(chatId).photo(new InputFile(new File("D:/one.jfif"))).build())
                .response(SendPhoto.builder().chatId(chatId).photo(new InputFile(new File("D:/two.jfif"))).build())
                .response(SendPhoto.builder().chatId(chatId).photo(new InputFile(new File("D:/three.jfif"))).build());
    }
}
