package net.rightpair.services.currency.conversion.client;

import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Configuration
public class CurrencyExchangeClientConfig {

    @Bean
    public Retryer retryConfig() {
        return new Retryer.Default(1000, 2000, 3);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return (s, response) -> switch (response.status()) {
            case 400 -> new RuntimeException(BAD_REQUEST.getReasonPhrase());
            case 500 -> new RuntimeException(INTERNAL_SERVER_ERROR.getReasonPhrase());
            default -> throw new IllegalStateException("Unexpected value: " + response.status());
        };
    }
}
