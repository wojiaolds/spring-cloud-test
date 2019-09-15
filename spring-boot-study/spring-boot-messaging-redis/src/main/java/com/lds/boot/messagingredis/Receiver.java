package com.lds.boot.messagingredis;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 22:41 2019/9/7
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 22:41 2019/9/7
 */
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    //接收消息
    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        latch.countDown();
    }
}
