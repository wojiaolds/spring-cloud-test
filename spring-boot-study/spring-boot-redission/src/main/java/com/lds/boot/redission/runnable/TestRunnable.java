package com.lds.boot.redission.runnable;

import com.lds.boot.redission.annotation.RedisLock;
import com.lds.boot.redission.service.TestService;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.util.concurrent.CountDownLatch;

import static jodd.util.ThreadUtil.sleep;

/**
 * @Author: lds
 * @Date: 2019/8/12 15:16
 */
public class TestRunnable implements Runnable{
	
	private TestService service;
	
	private CountDownLatch latch;
	
	public TestRunnable(TestService service,CountDownLatch latch){
		this.service = service;
		this.latch = latch;
	}
	
	@Override
	public void run () {
		
		try {
			service.process();
		}catch ( Exception e ){
			System.out.println (e);
		}
		latch.countDown ();
		
		
	}
}