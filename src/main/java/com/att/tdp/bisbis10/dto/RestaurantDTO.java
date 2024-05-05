package com.att.tdp.bisbis10.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RestaurantDTO {
    private Long id;
    private String name;
    // need to add AvgRatingDTO
    private boolean isKosher;
    private Set<String> cuisines;
    private List<DishDTO> dishes;

    public RestaurantDTO() {}

    public RestaurantDTO(Long id, String name, boolean isKosher, Set<String> cuisines) {
        this.id = id;
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
        this.dishes = new ArrayList<DishDTO>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isKosher() {
        return this.isKosher;
    }

    public void setKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public Set<String> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

    public List<DishDTO> getDishes() {
        return this.dishes;
    }

    public void setDishes(List<DishDTO> dishes) {
        this.dishes = dishes;
    }

}
