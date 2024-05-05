package com.att.tdp.bisbis10.dto;

public class CreateDishDTO {
    private String name;
    private String description;
    private double price;

    public CreateDishDTO() {}
    public CreateDishDTO(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

