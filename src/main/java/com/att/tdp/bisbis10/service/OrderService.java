package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.CreateOrderDTO;
import com.att.tdp.bisbis10.dto.OrderDTO;
import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.Order;
import com.att.tdp.bisbis10.entity.OrderItem;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repositories.DishRepository;
import com.att.tdp.bisbis10.repositories.OrderRepository;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final RestaurantRepository restaurantRepository;

    private final DishRepository dishRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository,DishRepository dishRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

     @Transactional
    public OrderDTO addOrder(CreateOrderDTO createOrderDTO) {
        Restaurant restaurant = this.restaurantRepository.findById(createOrderDTO.getRestaurantId()).orElseThrow(
                () -> new RuntimeException("Restaurant not found"));
        Order newOrder = new Order();
        Set<OrderItem> orderItems = createOrderDTO.getOrderItems().stream().map(dto-> {
            Dish dish = dishRepository.findById(dto.getDishId()).orElseThrow(
                    ()->new RuntimeException("Dish not found"));

            return new OrderItem(newOrder,dish,dto.getAmount());
        }).collect((Collectors.toSet()));
        newOrder.setOrderItems(orderItems); // make the link between order and order items
        newOrder.setRestaurant(restaurant); // make the link between restaurant and order
        Order order = this.orderRepository.save(newOrder);  // save in order table and in order items
        OrderDTO dto = new OrderDTO();
        dto.setOrderId(order.getUuid());
        return dto;
    }
}
