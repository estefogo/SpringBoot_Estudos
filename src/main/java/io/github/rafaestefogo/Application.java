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
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientsRepository,
                                  @Autowired OrderRepository orderRepository) {
        return args -> {
            //SAVING CLIENTS
            ClientEntity Pessoinha = new ClientEntity("Pessoinha", 20);
            clientsRepository.save(Pessoinha);

            OrderEntity order1 = new OrderEntity(Pessoinha, LocalDate.now(), BigDecimal.valueOf(1000));
            orderRepository.save(order1);

            OrderEntity order2 = new OrderEntity(Pessoinha, LocalDate.now(), BigDecimal.valueOf(500));
            orderRepository.save(order2);

            /*ClientEntity client = clientsRepository.findClientFetchOrders(order1.getClient().getId());
            System.out.println(client+"\n");
            System.out.println(client.getClientOrder()+"\n");*/

            orderRepository.findByClient(Pessoinha).forEach(System.out::println); //forma diferente de chamar o metodo findByClient e exibir todos os registros da lista

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("\n\nInitializing application...");
    }
}