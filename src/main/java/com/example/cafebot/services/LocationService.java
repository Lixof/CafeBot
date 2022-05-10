package com.example.cafebot.services;

import com.example.cafebot.persistence.cafe.Cafe;
import com.example.cafebot.persistence.cafe.CafeMapper;
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

    public void process(SendPhoto sendPhoto, SendLocation sendLocation, Update update) {

        long[] monId = near.process(update);

        Cafe cafe = cafeMapper.getById(monId[2]);

        sendPhoto.setPhoto(new InputFile(cafe.getImage()));
        sendPhoto.setCaption(cafe.getName() + "\n" + cafe.getDesc());
        sendLocation.setLatitude(cafe.getLatitude());
        sendLocation.setLongitude(cafe.getLongitude());
        responseInterface.defaultResponse(sendPhoto);
        responseInterface.defaultResponse(sendLocation);

        cafe = cafeMapper.getById(monId[1]);

        sendPhoto.setPhoto(new InputFile(cafe.getImage()));
        sendPhoto.setCaption(cafe.getName() + "\n" + cafe.getDesc());
        sendLocation.setLatitude(cafe.getLatitude());
        sendLocation.setLongitude(cafe.getLongitude());
        responseInterface.defaultResponse(sendPhoto);
        responseInterface.defaultResponse(sendLocation);

        cafe = cafeMapper.getById(monId[0]);

        sendPhoto.setPhoto(new InputFile(cafe.getImage()));
        sendPhoto.setCaption(cafe.getName() + "\n" + cafe.getDesc());
        sendLocation.setLatitude(cafe.getLatitude());
        sendLocation.setLongitude(cafe.getLongitude());
        responseInterface.defaultResponse(sendPhoto);
        responseInterface.defaultResponse(sendLocation);

    }
}
