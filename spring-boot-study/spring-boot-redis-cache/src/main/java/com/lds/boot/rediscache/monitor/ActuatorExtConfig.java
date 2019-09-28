package com.lds.boot.rediscache.monitor;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 18:36 2019/9/8
 */

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.actuate.amqp.RabbitHealthIndicator;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.boot.actuate.redis.RedisHealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import javax.sql.DataSource;


/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 18:36 2019/9/8
 */
@Configuration
public class ActuatorExtConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public HikariCPEndpoint hikariCPEndpoint(DataSource dataSource){
        return new HikariCPEndpoint((HikariDataSource) dataSource);
    }


}
