package com.example.cafebot.persistence.cafe;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CafeMapper {
    Cafe getById(long id);
    List<Cafe> getAll();
}
