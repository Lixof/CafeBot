package com.example.cafebot.utils;

import com.example.cafebot.persistence.location.Location;
import com.example.cafebot.persistence.location.LocationMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@RequiredArgsConstructor
public class LocationsList {

    private final LocationMapper locationMapper;
    private List<Location> locations;

    @Scheduled(fixedDelayString = "P1D")
    public void process() {
        List<Location> list = locationMapper.getAll();
        locations = list;
    }
}
