package com.lds.example.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }

    /**
     * Spring Cloud Gateway 网关路由有两种配置方式：
     *  在配置文件 yml 中配置
     *  通过@Bean自定义 RouteLocator，在启动主类 Application 中配置
     *  这两种方式是等价的，建议使用 yml 方式进配置
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("path_route", r -> r.path("/about")
//                        .uri("http://ityouknow.com"))
//                .build();
//    }
}
