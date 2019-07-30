package com.lds.boot.listener;

import com.lds.boot.event.MailSendEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/7/25 15:56
 */
@Component
public class MailSendListener implements ApplicationListener<MailSendEvent> {
	
	@Override
	public void onApplicationEvent ( MailSendEvent event ) {
		System.out.println("MailSender向"+ event.getTo()+ "发送了邮件");
	}
}
