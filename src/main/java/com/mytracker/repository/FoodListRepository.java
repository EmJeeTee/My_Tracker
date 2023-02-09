package com.mytracker.repository;

import com.mytracker.model.FoodList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodListRepository extends JpaRepository<FoodList,Long> {
}
