package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.CreateRestaurantDTO;
import com.att.tdp.bisbis10.dto.RestaurantListDTO;
import com.att.tdp.bisbis10.service.RestaurantService;
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
        List <RestaurantListDTO> restaurants= this.restaurantsService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    // Get restaurants by id
    @GetMapping("/{id}")
    ResponseEntity<Boolean> getRestaurant(@PathVariable Long id) {

        return ResponseEntity.ok(true);
    }

    // add a restaurant
    @PostMapping()
    ResponseEntity<Void> createRestaurant(@RequestBody CreateRestaurantDTO restaurant) {
        this.restaurantsService.createRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // update a restaurants
    @PutMapping("/{id}")
    ResponseEntity<Boolean> PutRestaurant(@PathVariable Long id) {
        return ResponseEntity.ok(true);
    }

    //delete a restaurants
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> DeleteRestaurant(@PathVariable Long id) {
        return ResponseEntity.ok(true);
    }

}