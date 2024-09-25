package com.springstatemachine.springstatemachine.service;

import com.springstatemachine.springstatemachine.component.AuxService;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final AuxService auxService;

    public OrderService(AuxService auxService) {
        this.auxService = auxService;
    }

    public void newOrder() {
        auxService.initOrderSaga();
        auxService.validateOrder();
    }

}
