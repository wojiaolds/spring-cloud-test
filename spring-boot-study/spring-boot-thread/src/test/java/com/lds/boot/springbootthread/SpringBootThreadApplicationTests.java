package com.lds.boot.springbootthread;

import com.lds.boot.springbootthread.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootThreadApplicationTests {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void contextLoads() throws Exception{
        log.info(Thread.currentThread().getName());
        Future<String> task1 = asyncTask.doTask();
        Future<String> task2 = asyncTask.doTask();

        while(true) {
            if(task1.isDone() && task2.isDone() ) {
                log.info("Task1 result: {}", task1.get());
                log.info("Task2 result: {}", task2.get());
                break;
            }
            Thread.sleep(1000);
        }

        log.info("All tasks finished.");

    }

}
