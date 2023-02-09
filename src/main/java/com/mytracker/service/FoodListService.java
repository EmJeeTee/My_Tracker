package com.mytracker.service;

import com.mytracker.model.FoodList;
import com.mytracker.request.FoodAddFoodListAndUserRequest;
import com.mytracker.request.FoodCreateRequest;
import com.mytracker.request.FoodIdUpdateInFoodListRequest;
import org.springframework.stereotype.Service;

public interface FoodListService {

    FoodList createFoodList(FoodAddFoodListAndUserRequest foodAddUserRequest);
    FoodList getFootListById(Long foodListId);

    String deleteFoodListById(Long foodListId);

    FoodList updateFoodInFoodList(Long foodListId, FoodIdUpdateInFoodListRequest foodIdUpdateInFoodListRequest);

}
