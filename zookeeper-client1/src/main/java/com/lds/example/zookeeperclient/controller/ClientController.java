package com.lds.example.zookeeperclient.controller;

import com.lds.example.zookeeperclient.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController

public class ClientController {


    private static final UUID INSTANCE_UUID = UUID.randomUUID();

    @Autowired
    private FeignService feignService;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(){
        System.out.println("test :" +INSTANCE_UUID.toString());
        return feignService.test();
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to springboot ！！！";
    }

    @GetMapping("/hello")
    public String hello(String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("zookeeper-server");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello?name=" + name;
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }


}
