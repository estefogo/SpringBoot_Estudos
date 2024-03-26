package io.github.rafaestefogo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

//--> PUXANDO A VARIAVEL "nomeDaAplicacao" DO ARQUIVO DE CONFIGURACAO
//@Autowired
//@Qualifier("exibirNomeApp")
//private String nomeDaAplicacao;

//--> PUXANDO A VARIAVEL "nomeDaAplicacao" DO application.properties DE ACORDO COM O AMBIENTE EM EXECUCAO
   @Value("${application.name}")
   private String nomeDaAplicacao;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/appName")
    public String appName() {
        return nomeDaAplicacao;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Inicializando aplicaçāo...");
        //a
    }
}