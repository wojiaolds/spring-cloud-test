package com.lds.example.springcloudconsumerapi.consul.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHelloApi {
    //定义提供者服务名
    String CONSUL_PRODUCER = "service-producer";

    /**
     * 定义接口
     * GET请求多个参数时，需要使用@RequestParam
     * GET请求参数为实体时，会自动转换成POST请求
     * POST请求使用@RequestBody注解参数
     * 不建议直接将@RequestMapping注解在类上，直接写在方法上
     * @param name
     * @return
     */
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}