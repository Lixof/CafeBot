package com.example.cafebot.persistence.cafe;

import lombok.Data;

@Data
public class Cafe {

    private long id;
    private double longitude;
    private double latitude;
    private String name;
    private String desc;
    private String image;
}
