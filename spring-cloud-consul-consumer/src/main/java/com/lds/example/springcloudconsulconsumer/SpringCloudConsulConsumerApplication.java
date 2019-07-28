package com.lds.example.springcloudconsulconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudConsulConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsulConsumerApplication.class, args);
    }

}
