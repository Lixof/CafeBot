package com.example.cafebot.utils;

import com.example.cafebot.persistence.cafe.Cafe;
import com.example.cafebot.persistence.cafe.CafeMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class Near {

    private final CafeMap cafeMap;
    private final Calculate calculate;

    public long[] process(Update update){

        double userLng = update.getMessage().getLocation().getLongitude();
        double userLat = update.getMessage().getLocation().getLatitude();
        long[] minId = new long[3];
        int[] minDistance = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        for(Cafe cafe : cafeMap.cafeMap().values()) {
            int i = calculate.process(userLat, userLng, cafe.getLatitude(), cafe.getLongitude());
            if (i < minDistance[2]) {
                if (i < minDistance[1]) {
                    if (i < minDistance[0]) {
                        minId[0] = cafe.getId();
                        minDistance[0] = i;
                    } else {
                        minId[1] = cafe.getId();
                        minDistance[1] = i;
                    }
                } else {
                minId[2] = cafe.getId();
                minDistance[2] = i;
                }
            }
        }
        return minId;
    }
}
