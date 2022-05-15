package com.example.cafebot.persistence.cafe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CafeMap {

    @PostConstruct
    private void postConstruct() { this.process(); }

    private final CafeMapper cafeMapper;
    private Map<Long, Cafe> cafeMap;

    public void process() { cafeMap = cafeMapper.getAll().stream().collect(Collectors.toMap(Cafe::getId, c -> c)); }

    public Map<Long, Cafe> cafeMap() { return cafeMap; }
}
