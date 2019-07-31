//package com.lds.example.rabbitmq.service.test;
//
//import com.lds.example.rabbitmq.service.test1.Config;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @Author: lds
// * @Date: 2019/7/29 10:24
// */
//@Component
//public class Sender {
//
//	@Autowired
//	private AmqpTemplate rabbitmqTemplate;
//
//	public void send(){
//		String content = "hello" + new Date ();
//		System.out.println("Sender:" +content);
//		//生产者Send会像Queue=hello发送一条消息
//		this.rabbitmqTemplate.convertAndSend(Config.routeKey, content);
//
//
//	}
//
//}
