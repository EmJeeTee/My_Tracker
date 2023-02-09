package com.mytracker.repository;
import com.mytracker.dto.FoodDto;
import com.mytracker.dto.FoodDto;
import com.mytracker.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
