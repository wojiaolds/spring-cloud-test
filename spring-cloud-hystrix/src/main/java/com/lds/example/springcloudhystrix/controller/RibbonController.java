package com.lds.example.springcloudhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon")
    @HystrixCommand(fallbackMethod="fallback")
    public String hello(String name) {

        return restTemplate.getForObject("http://service-producer/hello?name=" + name, String.class);
    }

    /**
     * 发生熔断时调用的方法
     * 这里fallback方法加入了一个参数throwable，
     * 当发生熔断时，可以获悉发生熔断的异常信息，便于定位问题和原因
     * @param name
     * @param throwable 发生异常时的异常信息
     * @return
     */
    public String fallback(String name,Throwable throwable) {

        return "restTemplate调用服务发生熔断，参数name：" + name;
    }
}