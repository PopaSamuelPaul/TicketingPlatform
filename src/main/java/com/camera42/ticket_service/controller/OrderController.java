package com.camera42.ticket_service.controller;

import com.camera42.ticket_service.model.TicketOrder;
import com.camera42.ticket_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping("/buy")
    @ResponseStatus(HttpStatus.CREATED)
    public TicketOrder createOrder(@RequestBody TicketOrder order){
        return service.createOrder(order.getUserEmail(),order.getEventId());
    }
}
