package com.lds.example.springcloudhystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="service-producer",/*fallback=HelloClientFailImpl.class,*/ fallbackFactory = HelloClientFallbackFactory.class)
public interface IHelloClient {

    /**
     * 定义接口
     * @param name
     * @return
     */
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String hello(@RequestParam("name") String name);
}
