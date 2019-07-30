package com.lds.example.rabbitmqproducer.controller;

import com.lds.example.rabbitmqproducer.config.RabbitmqProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitmqProperties rabbitmqProperties;

    @GetMapping("f")
    public String sendf(String message){
        rabbitTemplate.convertAndSend(rabbitmqProperties.getFanoutexchangeName(),
                null,message);
        return "success";
    }

    @GetMapping("d")
    public String sendd(String message){
        rabbitTemplate.convertAndSend(rabbitmqProperties.getDirectexchangeName(),
                rabbitmqProperties.getDirectrouteKey(),message);
        return "success";
    }
}
