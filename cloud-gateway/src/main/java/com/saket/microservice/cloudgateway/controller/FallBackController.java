package com.saket.microservice.cloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallback() {
        return Mono.just("Order Service is taking to long to respond. Please try again later");
    }

    @RequestMapping("/paymentFallBack")
    public Mono<String> paymentServiceFallback() {
        return Mono.just("Payment Service is taking to long to respond. Please try again later");
    }
}
