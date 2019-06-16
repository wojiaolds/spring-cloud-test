package com.lds.example.zookeeperclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * feign内部也使用了ribbon做负载均衡
 */

@FeignClient(value = "zookeeper-server",fallback = FeignFallback.class)
public interface FeignService {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String test();
}

