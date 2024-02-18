package com.futurebank.accountService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    /**
     * JWT Secret key for signing and verifying the JWT token.
     */
    @NotBlank
    private String jwtSecret;

    /**
     * Expiration time for JWT tokens in milliseconds.
     */
    @Positive
    private long jwtExpirationMs;

    /**
     * Bean for RestTemplate to make REST calls.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // Since we're using Lombok, explicit getters and setters are not needed.
    // You can add more fields here to match other properties prefixed with 'app',
    // and Lombok will generate getters and setters automatically.
}
