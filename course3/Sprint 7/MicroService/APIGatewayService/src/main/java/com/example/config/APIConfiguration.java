package com.example.config;

import com.example.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfiguration {
        @Bean
        public RouteLocator myRoutes(RouteLocatorBuilder builder){
            return builder.routes()
                    .route(p -> p
                            .path("/api/v1/**")
                            .uri("http://localhost:8085"))
                    .route(p -> p
                            .path("/api/prod/**")
                            .uri("http://localhost:8073"))
                    .build();
        }

        @Bean
        public FilterRegistrationBean jwtFilterBean(){
                FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
                filterRegistrationBean.setFilter(new JwtFilter());
                filterRegistrationBean.addUrlPatterns("/api/prod/**");
                return filterRegistrationBean;
        }

}
