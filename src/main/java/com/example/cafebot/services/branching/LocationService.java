package com.example.cafebot.services.branching;

import com.example.cafebot.persistence.cafe.Cafe;
import com.example.cafebot.persistence.cafe.CafeMapper;
import com.example.cafebot.services.response.ResponseInterface;
import com.example.cafebot.utils.Near;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final ResponseInterface responseInterface;
    private final Near near;
    private final CafeMapper cafeMapper;

    public void process(String chatId, Update update) {

        long[] monId = near.process(update);

        for (long id : monId) {

            Cafe cafe = cafeMapper.getById(id);
            responseInterface.response(SendPhoto.builder().chatId(chatId).photo(new InputFile(cafe.getImage())).caption(cafe.getName() + "\n\n" + cafe.getDesc()).build())
                    .response(SendLocation.builder().chatId(chatId).latitude(cafe.getLatitude()).longitude(cafe.getLongitude()).build());
        }
    }
}
