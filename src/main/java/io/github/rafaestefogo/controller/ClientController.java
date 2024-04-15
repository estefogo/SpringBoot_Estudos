package io.github.rafaestefogo.controller;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import io.github.rafaestefogo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/name/{name}")
    @ResponseBody
    public ResponseEntity<ClientEntity> findClientByName(@PathVariable("name") String clientName) {
        ClientEntity client = clientRepository.findClientByName(clientName);
        if(client.equals(null)) {
            System.out.println("The required name does not match with any register.");
        } else {
            return ResponseEntity.of(client.get());
        }
    }
}