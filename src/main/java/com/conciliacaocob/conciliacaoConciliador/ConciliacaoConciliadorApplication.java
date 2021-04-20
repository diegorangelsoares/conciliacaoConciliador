package com.conciliacaocob.conciliacaoConciliador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConciliacaoConciliadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConciliacaoConciliadorApplication.class, args);
        System.out.println("\n <<<<< API CONCILIADOR ESTÁ EM EXECUÇÃO >>>>>\n" +
                "\n" +
                "Link de acesso ao Swagger http://localhost:8089/conciliacaoConciliador/swagger-ui/\n" +
                "\n" +
                "\n" +
                "\n");
    }

}
