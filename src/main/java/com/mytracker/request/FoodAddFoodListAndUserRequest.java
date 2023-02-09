package com.mytracker.request;

import lombok.Data;

@Data
public class FoodAddFoodListAndUserRequest {
    private Long userId;
    private Long foodId;
    private Long id;
}
