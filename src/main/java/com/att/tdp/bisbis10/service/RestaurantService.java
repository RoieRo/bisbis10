package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.CreateRestaurantDTO;
import com.att.tdp.bisbis10.dto.RestaurantListDTO;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.mappers.RestaurantMapper;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantMapper mapper;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper mapper) {
        this.restaurantRepository = restaurantRepository;
        this.mapper = mapper;
    }

    public List<RestaurantListDTO> getAllRestaurants() {
        List<Restaurant> restaurants = this.restaurantRepository.findAll();
        return restaurants.stream()
                .map(mapper::restaurantToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Restaurant createRestaurant(CreateRestaurantDTO dto) {
        Restaurant restaurant = this.mapper.createRestaurantToEntity(dto);
        return restaurantRepository.save(restaurant);
    }

}

