//package com.lds.example.rabbitmq.service.test1;
//
//import com.lds.example.rabbitmq.domain.SendLog;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: lds
// * @Date: 2019/7/30 14:13
// */
//@Component
//public class MessageHandler {
//
//	//没有设置默认的处理方法的时候，方法名是handleMessage
//	public void handleMessage(byte[] message){
//		System.out.println("---------handleMessage-------------");
//		System.out.println(new String(message));
//	}
//
//
//	//通过设置setDefaultListenerMethod时候指定的方法名
//	public void onMessage(SendLog message){
//		System.out.println("---------onMessage-------------");
//		System.out.println(message);
//	}
//
//	//以下指定不同的队列不同的处理方法名
//	public void onorder(byte[] message){
//		System.out.println("---------onorder-------------");
//		System.out.println(new String(message));
//	}
//
//	public void onpay(byte[] message){
//		System.out.println("---------onpay-------------");
//		System.out.println(new String(message));
//	}
//
//	public void oninfo(byte[] message){
//		System.out.println("---------oninfo-------------");
//		System.out.println(new String(message));
//	}
//
//}
