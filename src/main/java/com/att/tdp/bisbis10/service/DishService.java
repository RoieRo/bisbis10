package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.repositories.DishRepository;
import com.att.tdp.bisbis10.entity.Dish;

public class DishService {
    private DishRepository dishRepository;
    public boolean addDish(Long restaurantId, Dish dish) {
        //dishRepository.addDish(dish);
        return true;
    }
}
