package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.UpdateDishDTO;
import com.att.tdp.bisbis10.dto.CreateDishDTO;
import com.att.tdp.bisbis10.mappers.DishMapper;
import com.att.tdp.bisbis10.repositories.DishRepository;
import com.att.tdp.bisbis10.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Dish getDishById(long id) {
        return this.dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Dish not found")
        );
    }

    public Dish updateDish(Dish dish, UpdateDishDTO updateDishDTO) {
        dish.setDescription(updateDishDTO.getDescription());
        dish.setPrice(updateDishDTO.getPrice());
        return dishRepository.save(dish);
    }

    public void deleteDish(Long dishId) {
        dishRepository.deleteById(dishId);
    }

//    public List<Dish> getDishesByRestaurantId(Long restaurantId) {
//        // Assuming dishRepository has a method to find dishes by restaurant ID
//        return dishRepository.findByRestaurantId(restaurantId);
//    }
}
