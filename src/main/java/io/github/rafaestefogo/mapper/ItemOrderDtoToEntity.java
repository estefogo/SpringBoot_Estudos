package io.github.rafaestefogo.mapper;

import io.github.rafaestefogo.domain.entity.ItemOrderEntity;
import io.github.rafaestefogo.domain.entity.OrderEntity;
import io.github.rafaestefogo.domain.entity.ProductEntity;
import io.github.rafaestefogo.domain.repository.ProductRepository;
import io.github.rafaestefogo.rest.dto.ItemOrderDto;
import io.github.rafaestefogo.rest.exceptions.BusinessRuleException;
import io.github.rafaestefogo.rest.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemOrderDtoToEntity {
    @Autowired
    private ProductRepository productRepository;


    public List<ItemOrderEntity> itemOrderDtoToEntity(OrderEntity order, List<ItemOrderDto> itemOrderDtoList) {
        if(itemOrderDtoList.isEmpty()) {
            throw new BusinessRuleException("The list is empty. Is not possible to register a new order.");
        }

        return itemOrderDtoList.stream().map(dto -> { //stream indica que o map sera feito com elementos de uma lista
            ProductEntity product = productRepository
                    .findById(dto.getProduct())
                    .orElseThrow(ProductNotFoundException::new);
            //pega o id do produto no objeto dto da lista e busca ele no repositorio

            ItemOrderEntity item = new ItemOrderEntity(); //cria um objeto ItemOrder do tipo entidade
            item.setClientOrder(order); //atribui à entidade o pedido associado ao item
            item.setProduct(product); //atribui à entidade o produto encontrado no repositorio
            item.setQuantity(dto.getQuantity()); //atribui à entidade a quantidade registrada no item dto
            return item; //retorna o objeto dto convertido pra entidade
        }).collect(Collectors.toList()); //indica o que deve ser feito com os objetos convertidos (transformados em uma lista)
    }
}