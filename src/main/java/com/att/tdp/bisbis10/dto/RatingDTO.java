package com.att.tdp.bisbis10.dto;

public class RatingDTO {
    private Long restaurantId;
    private double rating;

    public RatingDTO() {}

    public RatingDTO(Long restaurantId, double rating) {
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}
