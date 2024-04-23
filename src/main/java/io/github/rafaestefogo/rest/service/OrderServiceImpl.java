package io.github.rafaestefogo.rest.service;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import io.github.rafaestefogo.domain.entity.ItemOrderEntity;
import io.github.rafaestefogo.domain.entity.OrderEntity;
import io.github.rafaestefogo.domain.entity.ProductEntity;
import io.github.rafaestefogo.domain.repository.ClientRepository;
import io.github.rafaestefogo.domain.repository.ItemOrderRepository;
import io.github.rafaestefogo.domain.repository.OrderRepository;
import io.github.rafaestefogo.domain.repository.ProductRepository;
import io.github.rafaestefogo.exception.BusinessRuleException;
import io.github.rafaestefogo.rest.dto.ItemOrderDto;
import io.github.rafaestefogo.rest.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ItemOrderRepository itemOrderRepository;

    @Override
    @Transactional //precisa colocar essa anotacao pq vai fazer uma operacao no banco de dados, e caso de qualquer problema durante a execucao
                  //do metodo, todo ele é cancelado
    public OrderEntity saveOrder(OrderDto dto) {
        Integer clientId = dto.getClient();
        ClientEntity client = clientRepository.findById(clientId).orElseThrow(() -> new BusinessRuleException("Client Id not found"));

        OrderEntity order = new OrderEntity();
        order.setTotalValue(dto.getTotal());
        order.setOrderDate(LocalDate.now());
        order.setClient(client);
        List<ItemOrderEntity> itemsOrderList = convertItems(order, dto.getItems());
        orderRepository.save(order);
        itemOrderRepository.saveAll(itemsOrderList);
        order.setItemOrder(itemsOrderList);
        return order;
    }

    public List<ItemOrderEntity> convertItems(OrderEntity order, List<ItemOrderDto> itemsOrderDto) {
        if(itemsOrderDto.isEmpty()) {
            throw new BusinessRuleException("There are no items in the order, isn't possible to make an order."); //nao esquecer de colocar o "throw" quando for lançar exceçao
        }
        return itemsOrderDto.stream().map(dto -> { //stream ??
                    ProductEntity itemProduct = productRepository.findById(dto.getProduct()) //pega o id do produto no objeto dto da lista e busca ele no repositorio
                                    .orElseThrow(() -> new BusinessRuleException("Product not found."));

                    ItemOrderEntity itemOrderEntity = new ItemOrderEntity(); //cria um objeto ItemOrder do tipo entidade
                    itemOrderEntity.setProduct(itemProduct); //atribui à entidade o produto encontrado no repositorio
                    itemOrderEntity.setClientOrder(order); //atribui à entidade o pedido associado ao item
                    itemOrderEntity.setQuantity(dto.getQuantity()); //atribui à entidade a quantidade registrada no item dto
                    return itemOrderEntity; //retorna o objeto dto convertido pra entidade
                }).collect(Collectors.toList()); //??
    }

}
