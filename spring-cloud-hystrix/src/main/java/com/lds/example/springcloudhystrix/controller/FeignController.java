package com.lds.example.springcloudhystrix.controller;

import com.lds.example.springcloudhystrix.service.IHelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign 熔断器示例
 */
@RestController
public class FeignController {

    @Autowired
    IHelloClient helloClient;

    @GetMapping("/feign")
    public String hello(String name) {

        return helloClient.hello(name);
    }

}