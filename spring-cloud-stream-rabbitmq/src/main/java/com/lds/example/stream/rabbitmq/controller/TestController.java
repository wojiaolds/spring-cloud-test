package com.lds.example.stream.rabbitmq.controller;

import com.lds.example.stream.rabbitmq.processor.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: lds
 * @Date: 2019/7/31 15:21
 */

@RestController
public class TestController {
	
	@Autowired
	private MyProcessor pipe;
	
	@GetMapping("test")
	public String test(String msg){
		pipe.output1 ().send (MessageBuilder.withPayload(msg).build());
		return  "消息发送成功："+msg;
	}
	
	
}
