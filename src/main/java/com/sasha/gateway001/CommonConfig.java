package com.sasha.gateway001;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonConfig {

    @Value("${dap.app.url}")
    String dapAppUrl;

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
                        .allowedOrigins(dapAppUrl)
                        .allowedMethods("GET", "POST", "DELETE", "PUT");
            }
        };
    }
}
