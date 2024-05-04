package com.att.tdp.bisbis10.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurants")
public class DishController {
    // add a dish
    @PostMapping("/{id}/dishes")
    ResponseEntity<Boolean> addDish(@PathVariable Long id) {
      //  dishService.addDish(id, dish);
        return ResponseEntity.ok(true);
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
