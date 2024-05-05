package com.att.tdp.bisbis10.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //the primary key
    private Long id;

    private String name;

    @Column(name = "is_kosher")
    private boolean isKosher;

    @ElementCollection
    @CollectionTable(name = "cuisines")
    @Column(name = "cuisines")
    private Set<String> cuisines;

    @ManyToMany
    @JoinTable(
            name = "restaurant_dish",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private Set<Dish> dishes = new HashSet<>();

    public Restaurant() {}

    public Restaurant(Long id, String name, Boolean isKosher, Set<String> cuisines) {
        this.id = id;
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
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

    public Boolean getIsKosher() {
        return this.isKosher;
    }

    public void setIsKosher(Boolean isKosher) {
        this.isKosher = isKosher;
    }

    public Set<String> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

   public Set<Dish> getDishes() {
        return this.dishes;
   }

   public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
   }

}