/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservices.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author rsmal
 */
@FeignClient(name = "order-service", url = "http://localhost:8090/orders")
public interface OrderClient {
    @GetMapping("/{id}")
    Object getOrderById(@PathVariable("id") Long id);
}

