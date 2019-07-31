package com.lds.example.stream.rabbitmq.processor;

import com.rabbitmq.client.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/7/31 15:03
 */
@Component
public class runner implements CommandLineRunner{
	
	@Autowired
	private MyProcessor pipe;
	
	@Override
	public void run ( String... args ) throws Exception {
		String msg = "dewce";
		pipe.output1 ().send (MessageBuilder.withPayload(msg).build());
		System.err.println("消息发送成功："+msg);
	
		
	}
	
}
