package net.rightpair.services.currency.exchange.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    @GetMapping("/circuit")
    @CircuitBreaker(name = "sample-circuit", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    public ResponseEntity<String> circuitBreaker() {
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/nothing-point", String.class);
        forEntity.getBody();
        return ResponseEntity.ok("Simple Circuit Breaker");
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback response!";
    }
}
