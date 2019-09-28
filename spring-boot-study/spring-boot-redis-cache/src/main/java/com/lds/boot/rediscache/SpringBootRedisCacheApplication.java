package com.lds.boot.rediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//开启缓存支持
@EnableCaching
public class SpringBootRedisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisCacheApplication.class, args);
    }

}
