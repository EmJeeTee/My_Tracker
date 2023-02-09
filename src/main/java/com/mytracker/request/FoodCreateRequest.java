package com.mytracker.request;

import lombok.Data;

@Data
public class FoodCreateRequest {

    private Long id;
    private String description;
    private Float kilocalories;
    private Float carbonhydrate;
    private Float protein;
    private Float fat;
}
