package io.github.rafaestefogo.mapper;

import io.github.rafaestefogo.domain.entity.OrderEntity;
import io.github.rafaestefogo.rest.dto.InfoOrderDto;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderEntityToInfoOrderDto {
    @Autowired
    private ItemOrderEntityToItemOrderDto itemOrderEntityToItemOrderDto;
    public InfoOrderDto orderEntityToInfoOrderDto(OrderEntity order) {
        return InfoOrderDto
                .builder()
                .code(order.getId())
                .orderDate(order.getOrderDate())
                .clientName(order.getClient().getName())
                .cpf(order.getClient().getCpf())
                .total(order.getTotalValue())
                .items(itemOrderEntityToItemOrderDto.itemOrderEntityToItemOrderDto(order.getItemOrder()))
                .build();
    }
}
