package com.lds.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MvcHandlerMappingApplicationTests {
	
	@Autowired
	private RedissonClient redissonClient;
	
	@Test
	public void set() {
		// 设置字符串
		RBucket<String> keyObj = redissonClient.getBucket("k1");
		keyObj.set("wojiaolds");
	}


	@Test
	public void contextLoads() {
	}

}
