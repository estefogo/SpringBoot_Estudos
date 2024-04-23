package io.github.rafaestefogo.rest.service;

import io.github.rafaestefogo.domain.entity.OrderEntity;
import io.github.rafaestefogo.rest.dto.OrderDto;

public interface OrderService {
    OrderEntity saveOrder(OrderDto dto);
}
