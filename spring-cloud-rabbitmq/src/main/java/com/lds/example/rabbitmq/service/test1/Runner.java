//package com.lds.example.rabbitmq.service.test1;
//
//import com.lds.example.rabbitmq.domain.SendLog;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: lds
// * @Date: 2019/7/30 13:29
// */
//
//@Component
//public class Runner implements CommandLineRunner {
//
//	private final RabbitTemplate                 rabbitTemplate;
//
//	{
//		System.out.println ("----初始化块-----");
//	}
//
//	public Runner( Receiver1 receiver, RabbitTemplate rabbitTemplate,
//				   Jackson2JsonMessageConverter messageConverter ) {
//		this.rabbitTemplate = rabbitTemplate;
//		this.rabbitTemplate.setMessageConverter (messageConverter);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Sending message...");
//		SendLog sendLog = new SendLog ();
//		sendLog.setId ("123");
//		rabbitTemplate.convertAndSend(Config.routeKey, sendLog);
//
//	}
//
//}
//
//
