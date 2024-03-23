package io.github.rafaestefogo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean(name = "exibirNomeApp")
    public String appName() {
        return "Aplicação para estudo";
    }
}
