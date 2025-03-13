/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservices.order.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.microservices.order.*;
import com.microservices.order.client.ProductClient;
import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderItem;
import com.microservices.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author rsmal
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductClient productClient;
    
    public Order createOrder(Order order) {


    for (OrderItem item : order.getOrderItems()) {
        item.setOrder(order);
        Object product = productClient.getProductById(item.getProductId());
        if (product == null) {
            throw new RuntimeException("Product not found: " + item.getProductId());
        }
    }

    return orderRepository.save(order);
}
    
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    
    // add orderItem to an existing order
    @Transactional
    public Order addOrderItemToOrder(Long orderId, OrderItem orderItem) {
        // search order
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));

        // validate product
        Object product = productClient.getProductById(orderItem.getProductId());
        if (product == null) {
            throw new RuntimeException("Product not found: " + orderItem.getProductId());
        }

        double subtotal = orderItem.getUnitPrice() * orderItem.getQuantity();
        orderItem.setSubtotal(subtotal);
        orderItem.setOrder(order);


        order.getOrderItems().add(orderItem);

        // Recalculate order´s totalAmount
        double totalAmount = order.getOrderItems().stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
        order.setTotalAmount(totalAmount);

       
        return orderRepository.save(order);
    }

    
    
    
}