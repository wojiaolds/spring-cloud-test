package com.lds.example.springcloudhystrix.service;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloClientFallbackFactory implements FallbackFactory<IHelloClient> {

    @Autowired
    @Qualifier("fallback")
    IHelloClient helloClient;

    @Override
    public IHelloClient create(Throwable cause) {

        return helloClient;
    }

}