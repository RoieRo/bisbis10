package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.*;
import com.att.tdp.bisbis10.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantsService;

    @Autowired
    public RestaurantController(RestaurantService restaurantsService) {
        this.restaurantsService = restaurantsService;
    }

    // get restaurants by cuisine
    @GetMapping()
    ResponseEntity<List<RestaurantListDTO>> getRestaurant(@RequestParam(value = "cuisine", required = false) String cuisine){
        List <RestaurantListDTO> restaurants= this.restaurantsService.getAllRestaurants(cuisine);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    // Get restaurants by id
    @GetMapping("/{id}")
    ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable Long id) {
        RestaurantDTO restaurantDTO = this.restaurantsService.getRestaurantById(id);
        return new ResponseEntity<>(restaurantDTO, HttpStatus.OK);
    }

    // add a restaurant
    @PostMapping()
    ResponseEntity<Void> createRestaurant(@RequestBody CreateRestaurantDTO restaurant) {
        this.restaurantsService.createRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // update a restaurants
    @PutMapping("/{id}")
    ResponseEntity<Void> updateRestaurant(@PathVariable Long id, @RequestBody UpdateRestaurantDTO updateRestaurantDTO) {
        boolean updated = this.restaurantsService.updateRestaurant(id, updateRestaurantDTO);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //delete a restaurants
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        boolean deleted = this.restaurantsService.deleteRestaurant(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/dishes")
    public ResponseEntity<Void> addDishToRestaurant(@PathVariable Long id, @RequestBody CreateDishDTO createDishDTO) {
        try {
            this.restaurantsService.addDishToRestaurant(id, createDishDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // update a dish
    @PutMapping("/{id}/dishes/{dishId}")
    ResponseEntity<Boolean> updateDish(@PathVariable Long id, @PathVariable Long dishId) {
        //dishService.updateDish(id, dishId, dish);
        return ResponseEntity.ok(true);
    }
    // delete a dish
    @DeleteMapping("/{id}/dishes/{dishId}")
    ResponseEntity<Void> deleteDish(@PathVariable Long id, @PathVariable Long dishId) {
        //dishService.deleteDish(id, dishId);
        return ResponseEntity.noContent().build();
    }

    // get dishes by resturant
    @GetMapping("/{id}/dishes")
    ResponseEntity<Boolean> getDishesByRestaurant(@PathVariable Long id) {
        //List<Dish> dishes = dishService.getDishesByRestaurant(id);
        return ResponseEntity.ok(true);
    }
}