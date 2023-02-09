package com.mytracker.service;

import com.mytracker.model.Food;
import com.mytracker.model.FoodList;
import com.mytracker.request.FoodAddFoodListAndUserRequest;
import com.mytracker.request.FoodCreateRequest;
import org.springframework.stereotype.Service;

@Service
public interface FoodService {


    Food createFood(FoodCreateRequest newFoodCreateRequest);

    Food getFoodById(Long foodId);

    String deleteFoodById(Long foodId);

}
