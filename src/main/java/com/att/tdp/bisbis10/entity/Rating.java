package com.att.tdp.bisbis10.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //the primary key
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "restaurant_id",nullable = false)
    private Restaurant restaurant;

    private double rating;

    public Rating(){}

    public Rating(Long id,Restaurant restaurant, double ratingId) {
        this.id = id;
        this.restaurant = restaurant;
        this.rating = ratingId;
    }

    public Restaurant getRestaurant() {return this.restaurant;}

    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant;}

    public double getRating() {return this.rating;}

    public void setRating(double rating) {this.rating = rating;}

    public Long getId() {return this.id;}

    public void setId(Long id) {this.id = id;}

}
