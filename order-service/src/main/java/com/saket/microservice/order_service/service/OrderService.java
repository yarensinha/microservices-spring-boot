package com.saket.microservice.order_service.service;

import com.saket.microservice.order_service.common.Payment;
import com.saket.microservice.order_service.common.TransactionRequest;
import com.saket.microservice.order_service.common.TransactionResponse;
import com.saket.microservice.order_service.entity.Order;
import com.saket.microservice.order_service.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){
        String response = "";
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        // rest call
        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
        response = paymentResponse
                .getPaymentStatus()
                .equalsIgnoreCase("SUCCESS")?"Payment processing successful and order placed ":"Payment Failed";
         orderRepo.save(order);
         return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTxnId(),response);
    }
}
