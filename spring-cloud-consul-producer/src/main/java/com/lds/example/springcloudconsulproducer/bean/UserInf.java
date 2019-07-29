package com.lds.example.springcloudconsulproducer.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lds
 * @Date: 2019/7/29 11:48
 */
@Data
@ConfigurationProperties(prefix="user")
public class UserInf {
	private String name;
	
}
