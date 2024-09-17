package az.atl.gatewayms.route;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RouteLocatorConfig {

    @Value("${app.url.customer}")
    private String customer;

    @Value("${app.url.order}")
    private String order;

    @Value("${app.url.product}")
    private String product;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path", r -> r.path("/customer-ms/**")
                        .uri(customer))
                .route("path", r -> r.path("/api/v1/orders/**")
                        .uri(order))
                .route("path", r -> r.path("/api/v1/products/**")
                        .uri(product))
                .build();
    }
}
