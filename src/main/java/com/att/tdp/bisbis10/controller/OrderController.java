package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.CreateOrderDTO;
import com.att.tdp.bisbis10.dto.OrderDTO;
import com.att.tdp.bisbis10.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> Order( @RequestBody CreateOrderDTO dto) {
        OrderDTO order = this.orderService.addOrder(dto);
        return ResponseEntity.ok(order);
    }
}
