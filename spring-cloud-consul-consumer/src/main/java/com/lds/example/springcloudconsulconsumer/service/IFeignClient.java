package com.lds.example.springcloudconsulconsumer.service;

import com.lds.example.springcloudconsumerapi.consul.service.IHelloApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = IHelloApi.CONSUL_PRODUCER)
public interface IFeignClient extends IHelloApi {

}
