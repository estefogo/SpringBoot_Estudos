package io.github.rafaestefogo.rest.controller;

import io.github.rafaestefogo.domain.entity.OrderEntity;
import io.github.rafaestefogo.rest.dto.OrderDto;
import io.github.rafaestefogo.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer saveOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto).getId();
    }
}
