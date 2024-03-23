package io.github.rafaestefogo.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
dessa forma, as configuracoes definidas aqui so serao aplicadas quando o ambiente definido for
o ambiente de desenvolvimento (dev). Dessa forma, a mensagem do metodo abaixo so sera exibida no log
se esse for o ambiente ativo.
*/

@Configuration
@Profile("dev")
public class ConfigDev {
    @Bean
    public CommandLineRunner msgExibicaoProfile() {
        return args -> {
            System.out.println("Rodando em ambiente de desenvolvimento");
        };
    }
}
