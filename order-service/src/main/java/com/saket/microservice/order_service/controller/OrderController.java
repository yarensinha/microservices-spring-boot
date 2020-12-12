package com.saket.microservice.order_service.controller;

import com.saket.microservice.order_service.common.Payment;
import com.saket.microservice.order_service.common.TransactionRequest;
import com.saket.microservice.order_service.common.TransactionResponse;
import com.saket.microservice.order_service.entity.Order;
import com.saket.microservice.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){
        return orderService.saveOrder(transactionRequest);
    }
}
