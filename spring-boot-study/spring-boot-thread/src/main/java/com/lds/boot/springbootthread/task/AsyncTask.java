package com.lds.boot.springbootthread.task;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 23:20 2019/9/8
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 23:20 2019/9/8
 */
@Component
@Slf4j
public class AsyncTask {
    //返回值为void或者Future
    @Async("taskExecutor")
    public Future<String> doTask() throws InterruptedException{
        log.info("{} Task started.",Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long end = System.currentTimeMillis();

        log.info("{} Task finished, time elapsed: {} ms.",Thread.currentThread().getName(), end-start);

        return new AsyncResult<>(Thread.currentThread().getName()+" Task accomplished!");
    }


}
