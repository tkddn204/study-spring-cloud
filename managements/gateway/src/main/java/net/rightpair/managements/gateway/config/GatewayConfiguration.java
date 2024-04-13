package net.rightpair.managements.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/currency/exchange/**")
                        .uri("lb://services-currency-exchange"))
                .route(p -> p.path("/currency/conversion/**")
                        .uri("lb://services-currency-conversion"))
                .build();
    }
}
