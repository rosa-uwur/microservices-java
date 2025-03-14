/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.microservices.payment.repository;

import com.microservices.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rsmal
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {}
