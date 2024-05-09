package io.github.rafaestefogo.mapper;

import io.github.rafaestefogo.domain.entity.ItemOrderEntity;
import io.github.rafaestefogo.rest.dto.InfoItemsOrderDto;
import io.github.rafaestefogo.rest.dto.ItemOrderDto;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ItemOrderEntityToItemOrderDto {
    public List<InfoItemsOrderDto> itemOrderEntityToItemOrderDto(List<ItemOrderEntity> items) {
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }

        return items.stream().map(item ->
                InfoItemsOrderDto
                        .builder()
                        .quantity(item.getQuantity())
                        .productDescription(item.getDescription())
                        .unitPrice(item.getProduct().getValue())
                        .build()
        ).collect(Collectors.toList());
    }
}
