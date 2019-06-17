package com.lds.example.zookeeperclient;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author: lds
 * @Date: 2019/6/17 10:40
 */
public class ServletInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder application) {
		System.out.println ("-------------ServletInitializer--------------");
		return application.sources(ZookeeperClientApplication.class);
	}
}
