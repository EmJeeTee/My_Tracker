package com.mytracker.controller;

import com.mytracker.model.Food;
import com.mytracker.model.FoodList;
import com.mytracker.model.Movement;
import com.mytracker.repository.FoodListRepository;
import com.mytracker.request.FoodAddFoodListAndUserRequest;
import com.mytracker.request.FoodIdUpdateInFoodListRequest;
import com.mytracker.request.MovementCreateRequest;
import com.mytracker.service.FoodListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodList")
@CrossOrigin
public class FoodListController {

    @Autowired
    FoodListService foodListService;

    @Autowired
    FoodListRepository foodListRepository;

    @PostMapping("/add")
    public ResponseEntity<Void> createFoodList(@RequestBody FoodAddFoodListAndUserRequest newFoodAddFoodListAndUserRequest)
    {
        FoodList foodList = foodListService.createFoodList(newFoodAddFoodListAndUserRequest);
        if(foodList != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{foodListId}")
    public String deleteFooListById(@PathVariable("foodListId") Long foodListId){ return foodListService.deleteFoodListById(foodListId);}

    @PutMapping("/{foodListId}")
    public FoodList updateFoodInFoodList(@PathVariable("foodListId")Long foodListId, @RequestBody FoodIdUpdateInFoodListRequest foodIdUpdateInFoodListRequest){
        return foodListService.updateFoodInFoodList(foodListId,foodIdUpdateInFoodListRequest);
    }
}
