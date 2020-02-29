package com.sasha.gateway001;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonConfig {

    @Value("${DAP_APP_URL}")
    String DAP_APP_URL;

    @Bean
    public Filter filter() {
        return new Filter();
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(DAP_APP_URL)
                        .allowedMethods("GET", "POST");
            }
        };
    }
}
