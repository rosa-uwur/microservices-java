/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservices.products.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author rsmal
 */
@RestController
@RequestMapping("/products")
class ProductController {
    private final String FAKE_STORE_API = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public List<Object> getAllProducts() {
        return restTemplate.getForObject(FAKE_STORE_API, List.class);
    }

    @GetMapping("/{id}")
    public Object getProductById(@PathVariable Long id) {
        return restTemplate.getForObject(FAKE_STORE_API + "/" + id, Object.class);
    }
}

