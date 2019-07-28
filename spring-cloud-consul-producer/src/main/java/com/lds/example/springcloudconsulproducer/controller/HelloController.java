package com.lds.example.springcloudconsulproducer.controller;

import com.lds.example.springcloudconsumerapi.consul.service.IHelloApi;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements IHelloApi {

    /**
     * 参数不加@Nullable  请求没传这个参数会请求报错
     * @param name
     * @return
     */
    @Override
    public String hello(@Nullable String name) {
        return name+" call consul producer one";
    }
}
