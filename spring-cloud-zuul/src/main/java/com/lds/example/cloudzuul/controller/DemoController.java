package com.lds.example.cloudzuul.controller;

import com.lds.example.cloudzuul.service.IFeignClient;
import com.lds.example.springcloudconsumerapi.consul.service.IHelloApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路由网关 直接被用户请求的服务
 * 外部服务跟系统内部服务不可能共用一个注册中心
 * 所以需要路由网关来统一处理外部请求
 * zuul 内部提供对外服务
 * 跟做参数校验 权限拦截等
 */
@RestController
@RequestMapping("/demo")
public class DemoController  {

    @Autowired
    private IFeignClient iFeignClient;

    @GetMapping("/hello")
    public String hello(String name) {
        System.out.println( "hi," + name + ",this is zuul api! ");
        return iFeignClient.hello(name);
    }

}