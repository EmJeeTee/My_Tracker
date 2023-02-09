package com.mytracker.request;

import lombok.Data;

@Data
public class FoodIdUpdateInFoodListRequest {
    private Long foodListId;
    private Long foodId;
    private Long userId;
}
