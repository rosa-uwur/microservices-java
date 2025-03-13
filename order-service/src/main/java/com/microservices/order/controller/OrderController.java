/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservices.order.controller;

import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderItem;
import com.microservices.order.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author rsmal
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId).orElse(null);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    
    @PostMapping("/{orderId}/items")
    public Order addOrderItemToOrder(@PathVariable Long orderId, @RequestBody OrderItem orderItem) {
        return orderService.addOrderItemToOrder(orderId, orderItem);
    }
}
