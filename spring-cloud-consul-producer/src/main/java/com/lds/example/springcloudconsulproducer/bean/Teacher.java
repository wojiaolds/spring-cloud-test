package com.lds.example.springcloudconsulproducer.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

import java.util.List;

/**
 * @Author: lds
 * @Date: 2019/7/29 14:18
 */
@Data
//@Profile ("dev")
@ConfigurationProperties(prefix = "teacher")
public class Teacher {
	private String        name;
	private List<UserInf> users;
}
