package com.lds.boot.redission.service;

import com.lds.boot.redission.annotation.RedisLock;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;

import static jodd.util.ThreadUtil.sleep;

/**
 * @Author: lds
 * @Date: 2019/8/12 15:58
 */
@Service
public class TestService {
	private String         name;
	private     BufferedWriter bufferedWriter;
	
	public String getName () {
		
		return name;
	}
	
	public void setName ( String name ) {
		
		this.name = name;
	}
	
	public BufferedWriter getBufferedWriter () {
		
		return bufferedWriter;
	}
	
	public void setBufferedWriter ( BufferedWriter bufferedWriter ) {
		
		this.bufferedWriter = bufferedWriter;
	}
	
	@RedisLock (key = "lds")
	public void process() throws Exception{
		
		for ( int i = 1 ; i <= 100 ; i++ ) {
			bufferedWriter.write ("线程" + name + "---->" + i+"\n");
			//                    bufferedWriter.newLine ();
			bufferedWriter.flush ();
			sleep (1);
		}
		
	}
}
