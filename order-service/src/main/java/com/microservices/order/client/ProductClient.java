/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author rsmal
 */
@FeignClient(name = "product-service", url = "http://localhost:8080/products/")
public interface ProductClient {
    @GetMapping("/{id}")
    Object getProductById(@PathVariable("id") Long id);
}
