package io.github.rafaestefogo.controller;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import io.github.rafaestefogo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/id/{id}")
    @ResponseBody
    public ResponseEntity<ClientEntity> getClientById(@PathVariable("id") Integer id) {
        Optional<ClientEntity> client = clientRepository.findById(id);

        if(client.isPresent()) {
            ResponseEntity<ClientEntity> responseEntity = new ResponseEntity<>(
                    client.get(),
                    HttpStatus.OK);
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }
}