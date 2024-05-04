package com.att.tdp.bisbis10.dto;


import java.util.Set;

public class CreateRestaurantDTO {

    private String name;
    private boolean isKosher;
    private Set<String> cuisines;
    public CreateRestaurantDTO() {}

    public CreateRestaurantDTO(String name, boolean isKosher, Set<String> cuisines) {
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIsKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public boolean getIsKosher() {
        return this.isKosher;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

    public Set<String> getCuisines() {
        return this.cuisines;
    }
}

