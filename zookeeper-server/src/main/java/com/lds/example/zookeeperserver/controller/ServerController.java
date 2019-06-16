package com.lds.example.zookeeperserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ServerController {

    private static final UUID INSTANCE_UUID = UUID.randomUUID();


    @GetMapping("/test")
    public String test(){
        System.out.println("test :" + INSTANCE_UUID.toString());
        return INSTANCE_UUID.toString();
    }

}
