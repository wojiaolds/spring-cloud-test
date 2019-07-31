//package com.lds.example.rabbitmq.service.test1;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author: lds
// * @Date: 2019/7/30 13:27
// */
//@Configuration
//public class Config {
//
//	public final static String queueName = "spring-boot-queue";
//	public final static String exchangeName = "spring-boot-exchange";
//	public final static String routeKey = "spring-boot-routeKey";
//	@Bean
//	Queue queue() {
//		return new Queue(queueName, false);
//	}
//
//	@Bean
//	TopicExchange exchange() {
//		return new TopicExchange(exchangeName);
//	}
//
//	@Bean
//	Binding binding( Queue queue, TopicExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with(routeKey);
//	}
//
////	@Bean
////	SimpleMessageListenerContainer container( ConnectionFactory connectionFactory,
////											  MessageListenerAdapter listenerAdapter) {
////		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
////		container.setConnectionFactory(connectionFactory);
////		container.setQueueNames(queueName);
////		container.setMessageListener(listenerAdapter);
////		return container;
////	}
////
////	@Bean
////	MessageListenerAdapter listenerAdapter( Receiver1 receiver1) {
////		return new MessageListenerAdapter(receiver1, "receiveMessage");
////	}
//
//	@Bean
//	public RabbitTemplate rabbitTemplate( ConnectionFactory connectionFactory){
//		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//		rabbitTemplate.setExchange(exchangeName);
//		rabbitTemplate.setRoutingKey(routeKey);
//		return rabbitTemplate;
//	}
//
//	@Bean
//	public SimpleMessageListenerContainer messageListenerContainer(
//		ConnectionFactory connectionFactory,MessageHandler messageHandler){
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(queueName);
//		container.setConcurrency ("3");
//		container.setConcurrentConsumers(5);
//		container.setMaxConcurrentConsumers(10);
//		//后置处理器，接收到的消息都添加了Header请求头
//		container.setAfterReceivePostProcessors(message -> {
//			message.getMessageProperties().getHeaders().put("desc",10);
//			return message;
//		});
//		//设置消费者的consumerTag_tag
//		container.setConsumerTagStrategy(queue -> queue);
//		//设置消费者的Arguments
//		Map<String, Object> args = new HashMap<>();
//		args.put("module","订单模块");
//		args.put("fun","发送消息");
//		container.setConsumerArguments(args);
//
//		MessageListenerAdapter adapter = new MessageListenerAdapter(messageHandler);
//		//设置处理器的消费消息的默认方法,如果没有设置，那么默认的处理器中的默认方式是handleMessage方法
////		adapter.setDefaultListenerMethod("onMessage");
//		Map<String, String> queueOrTagToMethodName = new HashMap<> ();
//		queueOrTagToMethodName.put(queueName,"onMessage");
////		queueOrTagToMethodName.put("pay","onpay");
////		queueOrTagToMethodName.put("zhihao.miao.order","oninfo");
//		adapter.setQueueOrTagToMethodName(queueOrTagToMethodName);
//		container.setMessageListener(adapter);
//
//
//		return container;
//	}
//
//}
