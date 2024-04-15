package io.github.rafaestefogo;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import io.github.rafaestefogo.domain.entity.OrderEntity;
import io.github.rafaestefogo.repository.ClientRepository;
import io.github.rafaestefogo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientsRepository,
                                  @Autowired OrderRepository orderRepository) {
        return args -> {
            //SALVANDO CLIENTES
            ClientEntity Pessoinha = new ClientEntity("Pessoinha", 20);
            clientsRepository.save(Pessoinha);

            OrderEntity order1 = new OrderEntity(Pessoinha, LocalDate.now(), BigDecimal.valueOf(1000));
            orderRepository.save(order1);

            OrderEntity order2 = new OrderEntity(Pessoinha, LocalDate.now(), BigDecimal.valueOf(500));
            orderRepository.save(order2);

            //LISTANDO PEDIDOS DE UM CLIENTE
            ClientEntity client = clientsRepository.findClientFetchOrders(order1.getClient().getId());
            System.out.println("Listando pedidos de um cliente:\n" + client);

            //BUSCANDO CLIENTES PELO ID DE UM PEDIDO
            ClientEntity findingClientByOrder = clientsRepository.findClientByOrderIdFetchOrders(1);
            System.out.println("\nEncontrando CLIENTE buscando pelo id do PEDIDO atrelado a ele:\n" + findingClientByOrder);

            //BUSCANDO PEDIDOS PELO CLIENTE ATRELADO A ELE
            System.out.println("\n\nEncontrando PEDIDO buscando pelo id do CLIENTE atrelado a ele: ");
            orderRepository.findByClient(Pessoinha).forEach(System.out::println); //forma diferente de chamar o metodo findByClient e exibir todos os registros da lista
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("\n\nInitializing application...");
    }
}