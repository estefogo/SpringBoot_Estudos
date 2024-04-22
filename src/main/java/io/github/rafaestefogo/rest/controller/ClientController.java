package io.github.rafaestefogo.rest.controller;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import io.github.rafaestefogo.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/listClients")
    public List<ClientEntity> listAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/findClientById/{id}")
    public ClientEntity getClientById(@PathVariable("id") Integer id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @PostMapping("/saveNewClient")
    @ResponseStatus(HttpStatus.CREATED) //define que o status em caso de sucesso eh CREATED ao inves de SUCESSO
        public ClientEntity save(@RequestBody ClientEntity client) {
            return clientRepository.save(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable Integer id) {
        clientRepository.findById(id)
                .map(client -> {
                    clientRepository.delete(client);
                    return client;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @PutMapping("/updateName/{id}/{name}")
    public ClientEntity updateClient(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(name);
                    clientRepository.save(client);
                    return client;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }
}