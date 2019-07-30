package com.lds.example.rabbitmq.service.test1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * 当你注册它去接收消息，你可以给它取任何的名字。
 * 其中，它有CountDownLatch这样的一个类，它是用于告诉发送者消息已经收到了，
 * 你不需要在应用程序中具体实现它，只需要latch.countDown()就行了。
 * @Author: lds
 * @Date: 2019/7/30 13:23
 */
@Component
public class Receiver1 {
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	
	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		latch.countDown();
	}
	
	public CountDownLatch getLatch() {
		return latch;
	}
	
}

