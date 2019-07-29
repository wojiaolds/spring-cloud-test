package com.lds.example.springcloudhystrix.service;

import org.springframework.stereotype.Component;

@Component("fallback")
public class HelloClientFailImpl implements IHelloClient{

    @Override
    public String hello(String name) {
        return "restTemplate调用[hello]服务发生熔断，参数name:" + name;
    }
}