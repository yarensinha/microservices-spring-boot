package com.saket.microservice.payment_service.service;

import com.saket.microservice.payment_service.entity.Payment;
import com.saket.microservice.payment_service.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTxnId(UUID.randomUUID().toString());
        return paymentRepo.save(payment);
    }

    public String paymentProcessing(){
        // api should be 3rd party payment gateway i.e paytm
        return new Random().nextBoolean()?"success":"false";
    }


    public Payment findPaymentHistoryByOrderId(int orderId) {
        return paymentRepo.findByOrderId(orderId);
    }
}
