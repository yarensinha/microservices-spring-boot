package com.saket.microservice.payment_service.repository;

import com.saket.microservice.payment_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
    Payment findByOrderId(int orderId);
}
