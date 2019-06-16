package com.lds.example.zookeeperclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类添加注解@EnableFeignClients为断路器的支持，
 * @EnableFeignClients为Feign客户端的支持。
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ZookeeperClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperClientApplication.class, args);
    }

}
