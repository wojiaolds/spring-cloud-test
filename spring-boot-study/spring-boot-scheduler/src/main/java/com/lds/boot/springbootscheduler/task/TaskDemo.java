package com.lds.boot.springbootscheduler.task;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 0:06 2019/9/9
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 0:06 2019/9/9
 */
@Component
@Slf4j
public class TaskDemo {

    @Async
    @Scheduled(cron = "0/1 * * * * *")
    public void scheduled1() throws InterruptedException {
        log.info("{} scheduled1 start {}",Thread.currentThread().getName(),LocalDateTime.now());
        Thread.sleep(3000);
        log.info("{} scheduled1 每1秒执行一次：{}",Thread.currentThread().getName(), LocalDateTime.now());
    }

    @Scheduled(fixedRate = 1000)
    public void scheduled2() throws InterruptedException {
        log.info("{} scheduled2 start {}",Thread.currentThread().getName(),LocalDateTime.now());
        Thread.sleep(3000);
        log.info("{} scheduled2 每1秒执行一次：{}",Thread.currentThread().getName(), LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduled3() throws InterruptedException {
        log.info("{} scheduled3 start {}",Thread.currentThread().getName(),LocalDateTime.now());
        Thread.sleep(5000);
        log.info("{} scheduled3 上次执行完毕后隔3秒继续执行：{}",Thread.currentThread().getName(), LocalDateTime.now());
    }
}
