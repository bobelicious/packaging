package com.l2.packaging.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de empacotamento do seu Manoel")
                        .version("V1")
                        .description("Sistema de automacao e otimizacao de empacotamento")
                        .termsOfService("https://www.l2code.com.br/pt")
                        .license(new License()
                                .name("Apache")
                                .url("https://www.l2code.com.br/pt")));
    }
}
