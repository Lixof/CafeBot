package com.example.cafebot.persistence.top;

import com.example.cafebot.persistence.cafe.Cafe;
import com.example.cafebot.persistence.cafe.CafeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TopMap {

    @PostConstruct
    private void postConstruct() { this.process(); }

    private final TopMapper topMapper;
    private final CafeMapper cafeMapper;
    private Map<Long, Cafe> topMap;

    public void process() {

        topMap = topMapper.getAll().stream()
                .collect(Collectors.toMap(Top::getId, t -> cafeMapper.getById(t.getIdCafe())));
    }

    public Map<Long, Cafe> topMap() { return topMap; }
}
