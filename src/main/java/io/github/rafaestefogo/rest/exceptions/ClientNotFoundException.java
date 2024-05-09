package io.github.rafaestefogo.rest.exceptions;

public class ClientNotFoundException extends RuntimeException { //precisa extender o RunTimeException pra que a classe se comporte como uma excecao

    public ClientNotFoundException() {
        super("Client not found.");
    }
}