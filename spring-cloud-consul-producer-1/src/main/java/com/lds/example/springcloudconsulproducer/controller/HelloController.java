package com.lds.example.springcloudconsulproducer.controller;

import com.lds.example.springcloudconsumerapi.consul.service.IHelloApi;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements IHelloApi {

    @Override
    public String hello(@Nullable String name) {
        return name+" call consul producer two";
    }
}
