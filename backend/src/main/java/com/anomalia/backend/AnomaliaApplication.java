package com.anomalia.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
        title = "Anomalia API",
        version = "1.0",
        description = "Cross-Domain Global Anomaly Detection API"
))
@SpringBootApplication
public class AnomaliaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnomaliaApplication.class, args);
    }
}