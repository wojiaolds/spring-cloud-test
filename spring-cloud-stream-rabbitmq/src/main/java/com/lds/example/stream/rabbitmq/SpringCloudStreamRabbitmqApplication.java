package com.lds.example.stream.rabbitmq;

import com.lds.example.stream.rabbitmq.processor.MyProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding (MyProcessor.class)
public class SpringCloudStreamRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamRabbitmqApplication.class, args);
	}
	

}
