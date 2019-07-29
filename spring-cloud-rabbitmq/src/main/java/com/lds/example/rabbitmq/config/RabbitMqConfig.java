package com.lds.example.rabbitmq.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lds.example.rabbitmq.constant.RabbitmqConstant;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lds
 * @Date: 2019/7/29 10:28
 */
@Configuration
public class RabbitMqConfig {
	//建立一个消息队列hello；
	@Bean
	public Queue helloQueue(){
		return new Queue ("hello");
	}
	
	/**
	 * 描述 : rabbitListenerContainerFactoryPlus
	 *
	 * @param rabbitListenerContainerFactory rabbitListenerContainerFactory
	 * @param jackson2JsonMessageConverter   jackson2JsonMessageConverter
	 * @return rabbitListenerContainerFactoryPlus
	 */
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactoryPlus(
		SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory,
		Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
		rabbitListenerContainerFactory.setMessageConverter(jackson2JsonMessageConverter);
		return rabbitListenerContainerFactory;
	}
	
	/**
	 * 描述 : jackson2JsonMessageConverter
	 *
	 * @param objectMapper objectMapper
	 * @return jackson2JsonMessageConverter
	 */
	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper objectMapper) {
		return new Jackson2JsonMessageConverter(objectMapper);
	}
	
	/**
	 * exchangeMessageLog
	 *
	 * @return DirectExchange
	 */
	@Bean
	public DirectExchange exchangeMessageLog() {
		return new DirectExchange(RabbitmqConstant.EXCHANGE_MESSAGE_LOG.class.getSimpleName(), true, false);
	}
	
	/**
	 * exchangeMessageLogDlx
	 *
	 * @return DirectExchange
	 */
	@Bean
	public DirectExchange exchangeMessageLogDlx() {
		return new DirectExchange(RabbitmqConstant.EXCHANGE_MESSAGE_LOG_DLX.class.getSimpleName(), true, false);
	}
}
