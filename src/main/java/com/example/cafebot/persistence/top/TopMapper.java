package com.example.cafebot.persistence.top;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TopMapper {

    List<Top> getAll();
}
