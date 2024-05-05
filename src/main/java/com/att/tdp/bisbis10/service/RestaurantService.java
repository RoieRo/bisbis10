package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.*;
import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.Rating;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.mappers.DishMapper;
import com.att.tdp.bisbis10.mappers.RestaurantMapper;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantMapper mapper;

    private final DishService dishService;

    private final DishMapper dishMapper;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository,DishService dishService, RestaurantMapper mapper, DishMapper dishMapper) {
        this.restaurantRepository = restaurantRepository;
        this.dishService = dishService;
        this.mapper = mapper;
        this.dishMapper = dishMapper;
    }
    private Double _calcAvgRating(Restaurant restaurant){
        return restaurant.getRatings().stream()
                .mapToDouble(Rating::getRating)
                .average()
                .orElse(0.0);
    }

    public List<RestaurantListDTO> getAllRestaurants(String cuisine) {
        List<Restaurant> restaurants;
        if (cuisine != null && !cuisine.isEmpty()) {
            restaurants = this.restaurantRepository.findByCuisine(cuisine);
        } else {
            restaurants = this.restaurantRepository.findAll();
        }
        return restaurants.stream()
                .map(restaurant -> {
                    RestaurantListDTO dto = mapper.restaurantToListDto(restaurant);
                    Double avgRating = this._calcAvgRating(restaurant);
                    dto.setAvgRating(avgRating);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    //Transactional used to define the scope of a single database transaction
    @Transactional
    public void createRestaurant(CreateRestaurantDTO dto) {
        Restaurant restaurant = this.mapper.createRestaurantToEntity(dto);
        restaurantRepository.save(restaurant);
    }

    public boolean deleteRestaurant(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            restaurantRepository.delete(optionalRestaurant.get());
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updateRestaurant(Long id, UpdateRestaurantDTO updateRestaurantDTO) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.setCuisines(updateRestaurantDTO.getCuisines());
            restaurantRepository.save(restaurant);
            return true;
        }
        return false;
    }

    public RestaurantDTO getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Restaurant not found"));
        RestaurantDTO dto = mapper.restaurantToDto(restaurant);
        Double avgRating = this._calcAvgRating(restaurant);
        dto.setAvgRating(avgRating);
        return dto;
    }

    @Transactional
    public void addDishToRestaurant(Long id, CreateDishDTO createDishDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Restaurant not found"));
        Dish dish = this.dishService.addDish(createDishDTO);
        restaurant.getDishes().add(dish);
        restaurantRepository.save(restaurant);
    }

    public void updateDish(Long id, Long dishId, UpdateDishDTO updateDishDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Dish dishToUpdate = dishService.getDishById(dishId);

        dishService.updateDish(dishToUpdate, updateDishDTO);

        restaurantRepository.save(restaurant);
    }

    @Transactional
    public void deleteDish(Long id, Long dishId) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Dish dishToDelete = dishService.getDishById(dishId);
        restaurant.getDishes().remove(dishToDelete); // delete the FK
        dishService.deleteDish(dishId); // delete the PK
    }

    public List<DishDTO> getDishesByRestaurantId(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        return restaurant.getDishes().stream()
                .map(dishMapper::dishToDto)
                .collect(Collectors.toList());
    }
}

