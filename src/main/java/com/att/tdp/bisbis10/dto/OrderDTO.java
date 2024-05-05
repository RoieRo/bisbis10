package com.att.tdp.bisbis10.dto;

import java.util.UUID;

public class OrderDTO {
    private String orderId;

    public OrderDTO() {}

    public OrderDTO(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
