package com.mytracker.service.Impl;

import com.mytracker.exception.NotFoundException;
import com.mytracker.model.Food;
import com.mytracker.repository.FoodRepository;
import com.mytracker.request.FoodCreateRequest;
import com.mytracker.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public Food createFood(FoodCreateRequest newFoodCreateRequest){
        Food newFood = new Food();
        newFood.setId(newFoodCreateRequest.getId());
        newFood.setDescription(newFoodCreateRequest.getDescription());
        newFood.setKilocalories(newFoodCreateRequest.getKilocalories());
        newFood.setFat(newFoodCreateRequest.getFat());
        newFood.setProtein(newFoodCreateRequest.getProtein());
        newFood.setCarbonhydrate(newFoodCreateRequest.getCarbonhydrate());
        return foodRepository.save(newFood);
    }

    @Override
    public Food getFoodById(Long foodId) {
        return foodRepository.findById(foodId).orElseThrow(() -> new NotFoundException(foodId));

    }

    @Override
    public String deleteFoodById(Long foodId)
    {
        if (!foodRepository.existsById(foodId)) {
            throw new NotFoundException(foodId);
        }
        foodRepository.deleteById(foodId);
        return "Food with id " +foodId+ " has been deleted success.";
    }
}
