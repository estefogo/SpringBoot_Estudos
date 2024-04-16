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

@SpringBootApplication
public class Application {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientsRepository,
                                  @Autowired OrderRepository orderRepository) {
        return args -> {
            //SALVANDO CLIENTES
            ClientEntity Pessoinha = new ClientEntity("Pessoinha", 20);
            clientsRepository.save(Pessoinha);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("\n\nInitializing application...");
    }
}