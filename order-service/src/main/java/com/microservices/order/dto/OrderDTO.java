/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservices.order.dto;

import com.microservices.order.model.Order;

/**
 *
 * @author rsmal
 */
public class OrderDTO {
    private Long id;
    private Long clientId;
    private Double totalAmount;
    private String status;

    public OrderDTO() {}
    public OrderDTO(Order order) {
        this.id = order.getId();
        this.clientId = order.getClientId();
        this.totalAmount = order.getTotalAmount();
        this.status = order.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
