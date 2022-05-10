package com.example.cafebot.persistence.location;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface LocationMapper {
    List<Location> getAll();
}
