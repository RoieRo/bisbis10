package com.att.tdp.bisbis10.dto;

public class UpdateDishDTO {
    private String description;
    private double price;

    public UpdateDishDTO() {}

    public UpdateDishDTO(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
