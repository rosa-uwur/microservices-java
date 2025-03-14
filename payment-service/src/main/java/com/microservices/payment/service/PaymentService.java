/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservices.payment.service;

import com.microservices.payment.client.OrderClient;
import com.microservices.payment.entity.Payment;
import com.microservices.payment.repository.PaymentRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
 *
 * @author rsmal
 */
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderClient orderClient;
    
    public Payment processPayment(Payment payment) {
        Object order = orderClient.getOrderById(payment.getOrderId());
        if (order == null) {
            throw new RuntimeException("Order not found: " + payment.getOrderId());
        }
        payment.setStatus("COMPLETED");
        return paymentRepository.save(payment);
    }
    
    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }
}
