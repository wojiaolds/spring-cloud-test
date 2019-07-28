package com.lds.example.springcloudhystrix.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MainConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplat() {
        return new RestTemplate();
    }
}
