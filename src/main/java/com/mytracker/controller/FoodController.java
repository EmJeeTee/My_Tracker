package com.mytracker.controller;

import com.mytracker.dto.FoodDto;
import com.mytracker.dto.UserDto;
import com.mytracker.model.Food;
import com.mytracker.model.FoodList;
import com.mytracker.model.User;
import com.mytracker.repository.FoodRepository;
import com.mytracker.repository.MovementRepository;
import com.mytracker.request.FoodAddFoodListAndUserRequest;
import com.mytracker.request.FoodCreateRequest;
import com.mytracker.service.FoodService;
import com.mytracker.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/food")
@CrossOrigin
public class FoodController {


    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @PostMapping("/add")
    public ResponseEntity<Void> createFood(@RequestBody FoodCreateRequest newFoodCreateRequest)
    {
        Food food = foodService.createFood(newFoodCreateRequest);
        if(food != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{foodId}")
    public FoodDto getFoodById(@PathVariable("foodId")Long foodId){
        Food food= foodService.getFoodById(foodId);
        return new FoodDto(food);
    }

    @DeleteMapping("/{foodId}")
    public String deleteFoodById(@PathVariable("foodId") Long foodId){ return foodService.deleteFoodById(foodId);}

}
