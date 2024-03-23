package io.github.rafaestefogo.service;

import io.github.rafaestefogo.model.Cliente;
import io.github.rafaestefogo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    public Repository repository;

    public void cadastrarCliente(Cliente cliente) {
        validarCliente(cliente);
        repository.persistirCliente(cliente);
    }

    public void validarCliente(Cliente cliente) {

    }


}
