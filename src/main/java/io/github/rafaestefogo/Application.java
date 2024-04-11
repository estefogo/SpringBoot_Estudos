package io.github.rafaestefogo;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import io.github.rafaestefogo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class Application {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientsRepository) {
        return args -> {
            //SAVING CLIENTS
            System.out.println("SAVING NEW CLIENTS");
            ClientEntity clienteRafaela = new ClientEntity("Rafaela", 20);
            ClientEntity clienteDenise = new ClientEntity("Denise", 46);
            ClientEntity clienteDenise2 = new ClientEntity("Denise Ferreira", 46);
            ClientEntity error = new ClientEntity("error", 00);
            clientsRepository.save(clienteRafaela);
            clientsRepository.save(clienteDenise);
            clientsRepository.save(clienteDenise2);
            clientsRepository.save(error);

            //LISTING ALL CLIENTS
            System.out.println("\nLISTING ALL CLIENTS");
            List<ClientEntity> clientsList = clientsRepository.findAll();
            clientsList.forEach(System.out::println);

            //FINDING CLIENT BY NAME
            List<ClientEntity> returnListFindByName = clientsRepository.findByNameContaining("Denise");
            if(!returnListFindByName.isEmpty()) {
                int listSize = returnListFindByName.size();
                for (int i = 0; i < listSize ; i++) {
                    System.out.println("\nClient: " + returnListFindByName.get(i).getName()
                    + "\nID: " + returnListFindByName.get(i).getId()
                    + "\nAge: " + returnListFindByName.get(i).getAge());
                }
            } else {
                System.out.println("\nThere are no clients with the required name.");
            }

            //using the other method for find a client by id using a manual query
            returnListFindByName.add(clientsRepository.findClientByNameQuery("Rafaela").get(0));
            System.out.println("\n" + returnListFindByName); //return both clients found by the name, using different methods
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Initializing application...");
    }
}