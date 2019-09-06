package com.lds.boot.redission;


import com.lds.boot.redission.runnable.TestRunnable;
import com.lds.boot.redission.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedissionApplicationTests {

    @Autowired
    private RedissonClient redissonClient;
    
    @Autowired
    private TestService service;
  

    @Test
    public void contextLoads() {
        
        RBucket<String> key = redissonClient.getBucket("newday");
        key.set("wojiaolds");
        
        System.out.println("存入的数据："+key.get());
        RBucket<String> key1 = redissonClient.getBucket("newday1");
        key1.set("刘灯松");
        System.out.println("存入的数据："+key1.get());
        // 获取字符串格式的数据
        RBucket<String> keyObj = redissonClient.getBucket("newday");
        String s = keyObj.get();
        RBucket<String> keyObj1 = redissonClient.getBucket("newday1");
        String s1 = keyObj1.get();
        System.out.println("存入的数据："+s);
        System.out.println("存入的数据："+s1);
        
    }
    
    @Test
    public void lockTest() throws Exception{
    
        final CountDownLatch latch = new CountDownLatch (10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor (5, 10, 30, TimeUnit.MILLISECONDS,
                                                                        new LinkedBlockingQueue<>(3));
        String filename = "F:\\javaproject\\spring-cloud-test\\spring-boot-study\\spring-boot-redission\\file\\1.txt";
        File file = new File (filename);
        FileWriter writer = new FileWriter (file);
        BufferedWriter bufferwriter = new BufferedWriter (writer);
    
        service.setBufferedWriter (bufferwriter);
        for(int i = 1; i<=10; i++){
            service.setName (String.valueOf (i));
            threadPoolExecutor.submit (new TestRunnable (service,latch));
        }
        
        threadPoolExecutor.shutdown ();
        
        System.out.println ("Main Thread wait!");
        latch.await ();
        System.out.println ("Main thread end!");
        bufferwriter.close ();
        writer.close ();
    
        
    }
    

}
