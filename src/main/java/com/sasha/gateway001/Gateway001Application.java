package com.sasha.gateway001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class Gateway001Application {

	public static void main(String[] args) {
		SpringApplication.run(Gateway001Application.class, args);
	}

}
