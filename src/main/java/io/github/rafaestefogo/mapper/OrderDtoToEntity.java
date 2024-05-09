package io.github.rafaestefogo.mapper;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import io.github.rafaestefogo.domain.entity.ItemOrderEntity;
import io.github.rafaestefogo.domain.entity.OrderEntity;
import io.github.rafaestefogo.domain.repository.ClientRepository;
import io.github.rafaestefogo.domain.repository.ProductRepository;
import io.github.rafaestefogo.rest.dto.OrderDto;
import io.github.rafaestefogo.rest.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public class OrderDtoToEntity {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired ItemOrderDtoToEntity itemOrderDtoToEntityMapper;

    public OrderEntity orderDtoToEntity(OrderDto dto) {
       OrderEntity order = new OrderEntity();
       List<ItemOrderEntity> items = itemOrderDtoToEntityMapper.itemOrderDtoToEntity(order, dto.getItems());

       ClientEntity client = clientRepository.findById(dto.getClient())
               .orElseThrow(ClientNotFoundException::new);

       order.setOrderDate(LocalDate.now());
       order.setClient(client);
       order.setTotalValue(dto.getTotal());
       order.setItemOrder(items);
       return order;
   }

}