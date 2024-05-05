package com.att.tdp.bisbis10.dto;

import java.util.Set;

public class RestaurantListDTO {
    private Long id;
    private String name;
    private boolean isKosher;
    private Set<String> cuisines;
    private Double avgRating;

    public RestaurantListDTO(Long id, String name, boolean isKosher,  Double avgRating) {
        this.id = id;
        this.name = name;
        this.isKosher = isKosher;
       this.avgRating = avgRating == null ? 0 : avgRating;
    }
    public RestaurantListDTO() {}


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
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

    public void setAvgRating(Double avgRating) { this.avgRating = avgRating; }

    public Double getAvgRating() { return avgRating; }

}
