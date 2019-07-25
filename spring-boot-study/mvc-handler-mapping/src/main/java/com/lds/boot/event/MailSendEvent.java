package com.lds.boot.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @Author: lds
 * @Date: 2019/7/25 15:51
 */
public class MailSendEvent extends ApplicationContextEvent {
	
	private String to;  //目的地
	
	public MailSendEvent(ApplicationContext source, String to) {
		super(source);
		this.to = to;
	}
	
	public String getTo(){
		return this.to;
	}
}
