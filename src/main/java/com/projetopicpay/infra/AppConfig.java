package com.projetopicpay.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    //criando a instância
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
