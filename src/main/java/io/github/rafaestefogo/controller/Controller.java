package io.github.rafaestefogo.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping
    public void exibeTexto() {
        System.out.println("oi");
    }
}
