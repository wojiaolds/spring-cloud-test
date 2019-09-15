package com.lds.boot.rediscache.monitor;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 19:10 2019/9/8
 */

import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.boot.actuate.redis.RedisHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import javax.sql.DataSource;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 19:10 2019/9/8
 */
@Configuration
public class HealthConfig {
    @Bean
    public DataSourceHealthIndicator dataSourceHealthIndicator(DataSource dataSource){
        return new DataSourceHealthIndicator(dataSource);
    }
    @Bean
    public RedisHealthIndicator redisHealthIndicator(RedisConnectionFactory connectionFactory){
        return new RedisHealthIndicator(connectionFactory);
    }

//    @Bean
//    public RabbitHealthIndicator rabbitHealthIndicator(RabbitTemplate rabbitTemplate){
//        return new RabbitHealthIndicator(rabbitTemplate);
//    }

}
