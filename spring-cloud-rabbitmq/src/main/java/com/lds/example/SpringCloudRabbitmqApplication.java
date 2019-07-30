package com.lds.example;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRabbitmqApplication.class, args);
	}

}
