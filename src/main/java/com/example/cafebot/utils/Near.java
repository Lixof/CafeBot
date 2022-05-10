package com.example.cafebot.utils;

import com.example.cafebot.persistence.location.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Near {

    private final LocationsList locationsList;
    private final Calculate calculate;

    public long[] process(Update update){

        double userLng = update.getMessage().getLocation().getLongitude();
        double usserLat = update.getMessage().getLocation().getLatitude();
        long[] minId = new long[3];
        int[] minDistance = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        List<Location> list = locationsList.getLocations();
        int i;

        for(Location loc : list) {
            i = calculate.process(usserLat, userLng, loc.getLatitude(), loc.getLongitude());
            if (i < minDistance[2]) {
                if (i < minDistance[1]) {
                    if (i < minDistance[0]) {
                        minId[0] = loc.getId();
                        minDistance[0] = i;
                    } else {
                        minId[1] = loc.getId();
                        minDistance[1] = i;
                    }
                } else {
                minId[2] = loc.getId();
                minDistance[2] = i;
                }
            }
        }
        return minId;
    }
}
