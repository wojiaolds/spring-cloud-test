package com.lds.example.rabbitmqproducer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RabbitmqProperties.class)
public class RabbitmqConfig {

    @Autowired
    private RabbitmqProperties rabbitmqProperties;

    @Bean("orderQueue")
    Queue orderQueue() {
        return new Queue(rabbitmqProperties.getOrderqueueName(), false);
    }

    @Bean("messageQueue")
    Queue messageQueue() {
        return new Queue(rabbitmqProperties.getMessagequeueName(), false);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(rabbitmqProperties.getDirectexchangeName());
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(rabbitmqProperties.getFanoutexchangeName());
    }

    @Bean
    Binding fanoutBinding(@Qualifier("orderQueue") Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    Binding directBinding(@Qualifier("messageQueue") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitmqProperties.getDirectrouteKey());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setExchange(rabbitmqProperties.getFanoutexchangeName());
//        rabbitTemplate.setRoutingKey(rabbitmqProperties.getFanoutrouteKey());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
