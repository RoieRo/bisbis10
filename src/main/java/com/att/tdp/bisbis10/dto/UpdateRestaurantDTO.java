package com.att.tdp.bisbis10.dto;

import java.util.List;
import java.util.Set;

public class UpdateRestaurantDTO {
    private Set<String> cuisines;

    public Set<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }
}

