package com.lds.example;

import com.lds.example.rabbitmq.service.test.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudRabbitmqApplicationTests {
	
	@Autowired
	private Sender sender;
	
	@Test
	public void contextLoads() {
		sender.send();
	}

}
