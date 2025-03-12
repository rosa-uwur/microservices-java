/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservices.costumer.model;

/**
 *
 * @author rsmal
 */
public class CostumerDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Long number;

    public CostumerDTO() {}
    public CostumerDTO(Costumer costumer) {
        this.id = costumer.getId();
        this.name = costumer.getName();
        this.email = costumer.getEmail();
        this.address = costumer.getAddress();
        this.number = costumer.getNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }


}
