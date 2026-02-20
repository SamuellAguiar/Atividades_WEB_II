package org.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayAPI {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("api-users", p -> p.path("/api/users")
                        .filters(f -> f.rewritePath("/api/users", "/users"))
                        .uri("lb://USERS-SERVICE"))
                .route("users", p -> p.path("/users/**")
                        .uri("lb://USERS-SERVICE"))
                .route("sales", p -> p.path("/sales/**")
                        .uri("lb://SALES-SERVICE"))
                .route("events", p -> p.path("/events/**")
                        .uri("lb://SALES-SERVICE"))
                .route("notifications", p -> p.path("/notifications/**")
                        .uri("lb://NOTIFICATIONS-SERVICE"))
                .build();
    }
}
