package com.lds.example.stream.rabbitmq.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author: lds
 * @Date: 2019/7/31 16:11
 */
public interface MyProcessor {
	String OUTPUT1 = "output1";
	String INPUT1 = "input1";
	String OUTPUT2 = "output2";
	String INPUT2 = "input2";
	String INPUT3 = "input3";
	
	@Output ("output1")
	MessageChannel output1();
	
	@Input ("input1")
	SubscribableChannel input1();
	
	@Output ("output2")
	MessageChannel output2();
	
	@Input ("input2")
	SubscribableChannel input2();
	@Input ("input3")
	SubscribableChannel input3();
}
