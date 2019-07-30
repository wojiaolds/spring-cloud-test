package com.lds.example.rabbitmqconsumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix="rabbitmq")
public class RabbitmqProperties {

    private String orderqueueName;

    private String messagequeueName;

    private String fanoutexchangeName;

    private String directexchangeName;

    private String directrouteKey;

    private String fanoutrouteKey;

    public String getDirectexchangeName() {
        return directexchangeName;
    }

    public void setDirectexchangeName(String directexchangeName) {
        this.directexchangeName = directexchangeName;
    }

    public String getDirectrouteKey() {
        return directrouteKey;
    }

    public void setDirectrouteKey(String directrouteKey) {
        this.directrouteKey = directrouteKey;
    }

    public String getOrderqueueName() {
        return orderqueueName;
    }

    public void setOrderqueueName(String orderqueueName) {
        this.orderqueueName = orderqueueName;
    }

    public String getMessagequeueName() {
        return messagequeueName;
    }

    public void setMessagequeueName(String messagequeueName) {
        this.messagequeueName = messagequeueName;
    }

    public String getFanoutexchangeName() {
        return fanoutexchangeName;
    }

    public void setFanoutexchangeName(String fanoutexchangeName) {
        this.fanoutexchangeName = fanoutexchangeName;
    }

    public String getFanoutrouteKey() {
        return fanoutrouteKey;
    }

    public void setFanoutrouteKey(String fanoutrouteKey) {
        this.fanoutrouteKey = fanoutrouteKey;
    }
}
