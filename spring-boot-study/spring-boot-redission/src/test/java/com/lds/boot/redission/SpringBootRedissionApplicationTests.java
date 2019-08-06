package com.lds.boot.redission;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.RedissonLock;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedissionApplicationTests {

    @Resource
    private RedissonClient redissonClient;

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

}
