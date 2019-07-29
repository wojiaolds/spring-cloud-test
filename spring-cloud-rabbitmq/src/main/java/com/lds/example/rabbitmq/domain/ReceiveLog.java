package com.lds.example.rabbitmq.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * ReceiveLog
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class ReceiveLog {

    /**
     * 描述 : 日志ID
     */
    private String logId;

    /**
     * 描述 : 消息ID
     */
    private String id;

    /**
     * 描述 : 队列
     */
    private String queues;

    /**
     * 描述 : 消息接收时间
     */
    private Date receiveDate;
}
