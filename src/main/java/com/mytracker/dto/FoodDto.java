package com.mytracker.dto;

import com.mytracker.model.Food;
import lombok.Data;

@Data
public class FoodDto {

    private Long id;

    private String description;

    private Float kilocalories;

    private Float carbonhydrate;

    private Float protein;

    private Float fat;

    public FoodDto(Food entity)
    {
        this.id=entity.getId();
        this.description=entity.getDescription();
        this.kilocalories=entity.getKilocalories();
        this.carbonhydrate=entity.getCarbonhydrate();
        this.protein=entity.getProtein();
        this.fat=entity.getFat();
    }
}
