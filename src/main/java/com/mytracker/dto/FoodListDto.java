package com.mytracker.dto;

import com.mytracker.model.Food;
import com.mytracker.model.FoodList;
import lombok.Data;

import java.util.List;

@Data
public class FoodListDto {

    private Long id;

    private Long userId;

    private List<Food> foodList;


    public FoodListDto(FoodList entity,List<Food> foodList){

        this.id=entity.getId();
        this.userId=entity.getUser().getId();
        this.foodList=foodList;
    }
}
