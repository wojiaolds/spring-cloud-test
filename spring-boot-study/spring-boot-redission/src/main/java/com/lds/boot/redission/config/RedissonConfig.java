package com.lds.boot.redission.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @ClassName RedissonConfig
 * @Description TODO
 * @Auther lds
 * @Date 2019/8/6 21:22
 * @Version 1.0
 **/

@Configuration
public class RedissonConfig {
    
    /**
     * 单机模式
     * @param configFile
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod="shutdown")
    @ConditionalOnProperty(name = "redisson.mode",havingValue = "single")
    RedissonClient singleRedissonClient( @Value ("classpath:/config/redisson-single-config.yml") Resource configFile) throws
                                                                                                         IOException {
        return getRedissonClient(configFile);
    }
    
    /**
     * 集群模式
     * @param configFile
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod="shutdown")
    @ConditionalOnProperty(name = "redisson.mode",havingValue = "cluster")
    RedissonClient clusterRedissonClient( @Value ("classpath:/config/redisson-cluster-config.yml") Resource configFile) throws
                                                                                                                IOException {
        return getRedissonClient(configFile);
    }
    
    /**
     * 哨兵模式自动装配
     * @return
     */
    @Bean(destroyMethod="shutdown")
    @ConditionalOnProperty(name = "redisson.mode",havingValue = "sentinel")
    RedissonClient sentinelRedissonClient( @Value ("classpath:/config/redisson-sentinel-config.yml") Resource configFile) throws
                                                                                                                        IOException {
      
        return getRedissonClient(configFile);
    }
    
    private RedissonClient getRedissonClient(Resource configFile) throws IOException{
        Config config = Config.fromYAML (configFile.getInputStream());
        config.setCodec(new StringCodec());
        return Redisson.create(config);
    }
    
    
}
