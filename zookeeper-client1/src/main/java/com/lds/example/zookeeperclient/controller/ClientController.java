package com.lds.example.zookeeperclient.controller;

import com.lds.example.zookeeperclient.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ClientController {


    private static final UUID INSTANCE_UUID = UUID.randomUUID();

    @Autowired
    private FeignService feignService;



    @GetMapping("/test")
    public String test(){
        System.out.println("test :" +INSTANCE_UUID.toString());
        return feignService.test();
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to springboot ！！！";
    }



}
