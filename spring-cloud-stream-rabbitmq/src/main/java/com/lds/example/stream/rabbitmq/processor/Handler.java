package com.lds.example.stream.rabbitmq.processor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/7/31 14:59
 */
@Component
public class Handler {
	
	@StreamListener (MyProcessor.INPUT1)
//		@SendTo (Processor.OUTPUT)
//    @ServiceActivator (inputChannel = MyProcessor.INPUT1,outputChannel = MyProcessor.OUTPUT2)

	public void messageInPut1(Message<String> message) {
		System.err.println(" messageInPut1消息接收成功：" + message.getPayload());
//		return message.getPayload();
		
	}
	@StreamListener (MyProcessor.INPUT2)
	public void messageInPut2(Message<String> message) {
		System.err.println(" messageInPut2消息接收成功：" + message.getPayload());
		
	}
	@StreamListener (MyProcessor.INPUT3)
	public void messageInPut3(Message<String> message) {
		System.err.println(" messageInPut3消息接收成功：" + message.getPayload());
		
	}
}
