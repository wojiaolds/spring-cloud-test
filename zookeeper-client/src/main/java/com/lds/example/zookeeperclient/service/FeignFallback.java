package com.lds.example.zookeeperclient.service;

import org.springframework.stereotype.Component;

/**
 * fallback: 定义容错的处理类，当调用远程接口失败或超时时，
 * 会调用对应接口的容错逻辑，fallback指定的类必须实现@FeignClient标记的接口
 */

@Component
public class FeignFallback implements FeignService {

    @Override
    public String test() {
        return "servie error!";
    }
}
