package com.lds.boot.redission.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RedissonConfig
 * @Description TODO
 * @Auther lds
 * @Date 2019/8/6 21:22
 * @Version 1.0
 **/

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient getRedisson(){
        Config config = new Config();
        //单机模式  依次设置redis地址和密码
        config.useSingleServer().
                setAddress("redis://192.168.99.100:6379");
        config.setCodec(new StringCodec());
        return Redisson.create(config);
    }
}
