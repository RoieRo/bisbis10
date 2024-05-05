package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.CreateDishDTO;
import com.att.tdp.bisbis10.mappers.DishMapper;
import com.att.tdp.bisbis10.repositories.DishRepository;
import com.att.tdp.bisbis10.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    private final DishRepository dishRepository;

    private final DishMapper dishMapper;

    @Autowired
    public DishService(DishRepository dishRepository, DishMapper dishMapper) {
        this.dishRepository = dishRepository;
        this.dishMapper = dishMapper;
    }

    public Dish addDish(CreateDishDTO createDishDTO) {
        Dish dish = this.dishMapper.createDishToEntity(createDishDTO);
        return this.dishRepository.save(dish);
    }

}
