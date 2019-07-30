package com.lds.example.rabbitmqproducer;

import com.lds.example.rabbitmqproducer.config.RabbitmqProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudRabbitmqProducerApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRabbitmqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
