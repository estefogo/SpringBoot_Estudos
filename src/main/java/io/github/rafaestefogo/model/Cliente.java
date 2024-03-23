package io.github.rafaestefogo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    private Long id;
    private String nome;
    private int idade;
    private String dataNasc;
    private String cpf;
    private char sexo;
}
