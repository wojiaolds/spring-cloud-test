package com.lds.example.rabbitmqconsumer.handler;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    @RabbitListener(queues = "${rabbitmq.orderqueueName}")
    public void orderProcess(String message){
        System.out.println("====消费消息===orderProcess");
        System.out.println(message);

    }

    @RabbitListener(queues = "${rabbitmq.messagequeueName}")
    public void messageProcess(String message){
        System.out.println("====消费消息===messageProcess");
        System.out.println(message);

    }
}
