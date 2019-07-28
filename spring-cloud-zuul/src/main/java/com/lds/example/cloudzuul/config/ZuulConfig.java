package com.lds.example.cloudzuul.config;

import com.lds.example.cloudzuul.Filter.error.CustomErrorFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Bean
    @ConditionalOnProperty(name="zuul.SendErrorFilter.error.disable")
    public CustomErrorFilter customErrorFilter(){
        return new CustomErrorFilter();
    }
}
