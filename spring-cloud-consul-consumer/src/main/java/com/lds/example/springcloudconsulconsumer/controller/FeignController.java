package com.lds.example.springcloudconsulconsumer.controller;

import com.lds.example.springcloudconsulconsumer.service.IFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private IFeignClient iFeignClient;

    @GetMapping("/hello")
    public String hello(String name) {
        return iFeignClient.hello(name);
    }
}
