package az.atl.gatewayms.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path", r -> r.path("/customer-ms/**")
                        .uri("http://localhost:8080"))
                .route("path", r -> r.path("/api/v1/orders/**")
                        .uri("http://localhost:8081"))
                .route("path", r -> r.path("/api/v1/products/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
