package com.lds.example.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/7/29 10:26
 */
@Component
//@RabbitListener表示对队列hello进行监听
@RabbitListener (queues = "hello")
public class Receiver {
	//@RabbitHandler指定对消息的处理方法
	@RabbitHandler
	public void process(String hello){
		System.out.println("Receiver:" + hello);
	}
}

