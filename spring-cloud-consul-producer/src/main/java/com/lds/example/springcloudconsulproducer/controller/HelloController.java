package com.lds.example.springcloudconsulproducer.controller;

import com.lds.example.springcloudconsulproducer.bean.Teacher;
import com.lds.example.springcloudconsulproducer.bean.UserInf;
import com.lds.example.springcloudconsumerapi.consul.service.IHelloApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//Spring Cloud Consul Config默认就支持动态刷新
@RefreshScope
@EnableConfigurationProperties ({ UserInf.class, Teacher.class})
public class HelloController implements IHelloApi {
    
    @Autowired
    private UserInf userInf;
    
    @Autowired
    private Teacher teacher;
    /**
     * 参数不加@Nullable  请求没传这个参数会请求报错
     * @param name
     * @return
     */
    @Override
    public String hello(@Nullable String name) {
        return name+" call consul producer one";
    }
    
    
    @GetMapping ("/user")
    public String getUser() {
        return userInf.getName ();
    }
    
    @GetMapping ("/teacher")
    public Teacher getTeacher() {
        
        return teacher;
    }
}
