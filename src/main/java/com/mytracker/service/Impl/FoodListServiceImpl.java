package com.mytracker.service.Impl;
import com.mytracker.exception.NotFoundException;
import com.mytracker.request.FoodCreateRequest;
import com.mytracker.request.FoodIdUpdateInFoodListRequest;
import com.mytracker.service.FoodListService;
import com.mytracker.service.FoodService;
import com.mytracker.model.Food;
import com.mytracker.model.FoodList;
import com.mytracker.model.User;
import com.mytracker.repository.FoodListRepository;
import com.mytracker.request.FoodAddFoodListAndUserRequest;
import com.mytracker.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional

@Service
public  class FoodListServiceImpl implements FoodListService {

    @Autowired
    FoodListRepository foodListRepository;

    @Autowired
    UserService userService;

    @Autowired
    FoodService foodService;


    @Override
    public FoodList createFoodList(FoodAddFoodListAndUserRequest foodAddFoodListAndUserRequest)
    {
        User userId = userService.getUserById(foodAddFoodListAndUserRequest.getUserId());
        Food foodId = foodService.getFoodById(foodAddFoodListAndUserRequest.getFoodId());
        if(userId==null || foodId == null)
            return null;
        FoodList newFoodList = new FoodList();
        newFoodList.setFood((List<Food>) foodId);
        newFoodList.setUser(userId);
        return foodListRepository.save(newFoodList);
    }

    @Override
    public FoodList getFootListById(Long foodListId) {
        return foodListRepository.findById(foodListId).orElseThrow(() -> new NotFoundException(foodListId));

    }

    @Override
    public String deleteFoodListById(Long foodListId)
    {
        if (!foodListRepository.existsById(foodListId)) {
            throw new NotFoundException(foodListId);
        }
        foodListRepository.deleteById(foodListId);
        return "Food with id " +foodListId+ " has been deleted success.";
    }

    @Override
    public FoodList updateFoodInFoodList(Long foodListId, FoodIdUpdateInFoodListRequest foodIdUpdateInFoodListRequest) {
        Optional <FoodList> foodList = foodListRepository.findById(foodListId);
        if(foodList.isPresent())
        {
            FoodList toFoodListUpdate = foodList.get();
            Food toFoodUpdate = foodList.get().getFood();
            toFoodUpdate.setId(foodIdUpdateInFoodListRequest.getFoodId());
            toFoodListUpdate.setFood(toFoodUpdate);
            return foodListRepository.save(toFoodListUpdate);
        }
        return null;
    }

}
