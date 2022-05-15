package com.example.cafebot.services.branching;

import com.example.cafebot.persistence.cafe.Cafe;
import com.example.cafebot.persistence.cafe.CafeMap;
import com.example.cafebot.services.response.ResponseInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

@Service
@RequiredArgsConstructor
public class IdService {

    private final ResponseInterface responseInterface;
    private final CafeMap cafeMap;

    public void process(String chatId, long id) throws Exception{

        Cafe cafe = cafeMap.cafeMap().get(id);
        responseInterface.response(SendPhoto.builder().chatId(chatId).photo(new InputFile(cafe.getImage())).caption(cafe.getId() + " " + cafe.getName() + "\n\n" + cafe.getDesc()).build()).response(SendLocation.builder().chatId(chatId).longitude(cafe.getLongitude()).latitude(cafe.getLatitude()).build());
    }
}
