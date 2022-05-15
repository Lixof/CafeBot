package com.example.cafebot.services.branching;

import com.example.cafebot.persistence.cafe.Cafe;
import com.example.cafebot.persistence.top.TopMap;
import com.example.cafebot.services.response.ResponseInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

@Service
@RequiredArgsConstructor
public class TopWeekService {

    private final ResponseInterface responseInterface;
    private final TopMap topMap;

    public void process(String chatId) {

        for (int i = 1 ; i < 11 ; i++ ) {

            Cafe cafe = topMap.topMap().get((long) i);

            responseInterface.response(SendPhoto.builder().chatId(chatId).photo(new InputFile(cafe.getImage())).caption(i + " " + cafe.getName() + "\n\n" + cafe.getDesc()).build())
                    .response(SendLocation.builder().chatId(chatId).longitude(cafe.getLongitude()).latitude(cafe.getLatitude()).build());
        }
    }
}
