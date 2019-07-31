//package com.lds.example.rabbitmq.service.test;
//
//import com.lds.example.rabbitmq.service.test1.Config;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: lds
// * @Date: 2019/7/29 10:26
// */
//@Component
////@RabbitListener表示对队列hello进行监听
//@RabbitListener (queues = Config.queueName)
//public class Receiver {
//	//@RabbitHandler指定对消息的处理方法
//	@RabbitHandler
//	public void process(String message){
//		System.out.println("Receiver:" + message);
//	}
//}
//
