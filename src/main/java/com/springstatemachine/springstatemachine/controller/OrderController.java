package com.springstatemachine.springstatemachine.controller;

import com.springstatemachine.springstatemachine.component.AuxService;
import com.springstatemachine.springstatemachine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final AuxService auxService;

    public OrderController(OrderService orderService, AuxService auxService) {
        this.orderService = orderService;
        this.auxService = auxService;
    }

    @PostMapping("/new")
    public String newOrder() {
        orderService.newOrder();
        return "New order processed";
    }

    @PostMapping("/pay")
    public String payOrder() {
        auxService.payOrder();
        return "Pay order processed";
    }

    @PostMapping("/ship")
    public String shipOrder() {
        auxService.shipOrder();
        return "Ship order processed";
    }

    @PostMapping("/complete")
    public String completeOrder() {
        auxService.completeOrder();
        return "Complete order processed";
    }
}
