package com.att.tdp.bisbis10.dto;

import java.util.List;

public class CreateOrderDTO {
    private Long restaurantId;
    private List<OrderItemDTO> orderItems;

    public CreateOrderDTO() {}

    public CreateOrderDTO(Long restaurantId, List<OrderItemDTO> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }



}
