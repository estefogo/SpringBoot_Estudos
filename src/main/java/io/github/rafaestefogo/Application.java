package io.github.rafaestefogo;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import io.github.rafaestefogo.repository.jpa.ClientRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class Application {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepositoryJpa clientsRepository) {
        return args -> {
            //TESTS SAVING CLIENTS
            System.out.println("SAVING NEW CLIENTS");
            clientsRepository.saveClient(new ClientEntity("Rafaela", 20));
            clientsRepository.saveClient(new ClientEntity("Denise", 46));
            clientsRepository.saveClient(new ClientEntity("error", 1));

            //TEST LISTING ALL CLIENTS
            System.out.println("\nLISTING ALL CLIENTS");
            List<ClientEntity> clientsList = clientsRepository.listClients();
            clientsList.forEach(System.out::println);

            /*//TEST UPDATING CLIENTS
            System.out.println("\nUPDATING CLIENTS");
            clientsRepository.updateClient("Rafaela", "Rafa Estefogo");
            clientsRepository.updateClient("Denise", "Denise Ferreira");
            clientsList = clientsRepository.listClients();
            clientsList.forEach(System.out::println);*/

            //TEST DELETING CLIENT
            System.out.println("\nDELETING CLIENT 'error'");
           clientsRepository.deleteClientById(3);
            clientsList = clientsRepository.listClients();
            clientsList.forEach(System.out::println);

            //TEST FINDING CLIENT BY NAME
            System.out.println("\nFINDING CLIENT BY NAME ('Den')");
            clientsRepository.findByName("Den").forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Initializing application...");
    }
}