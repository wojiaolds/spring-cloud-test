package com.lds.boot.listener;

import com.lds.boot.event.MailSendEvent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class MyContextListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyContextListener.class);

    private static int counter;

    @Autowired
    private ServerProperties properties;
    
    private ApplicationContext applicationContext;



    @EventListener
    public void handle(Object event) throws IOException {
        System.out.println("*********" + (++counter) + ": " + event.toString() + "*********");
        if(event instanceof ApplicationReadyEvent){
            LOGGER.info("Application Ready");
            String ctx = properties.getServlet().getContextPath();
            ApplicationContext act = ContextLoader.getCurrentWebApplicationContext();


            if (StringUtils.isEmpty(ctx)) {
                ctx = "/";
            } else {
                ctx = ctx + "/";
            }

            String portPart = "";
            Integer port = properties.getPort();
            if(port == null) port = 8080;
            if (port!=80) {
                portPart = ":" + port;
            }
            String host = null;
            try {
                host = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                // e.printStackTrace();
            }
            if (StringUtils.isEmpty(host)) {
                host = "127.0.0.1";
            }
            String message = String.format("Access URLS: External: %s%s%s%s%s", "http://", host, portPart, ctx, "swagger-ui.html");
            message+= String.format(" , %s%s%s%s%s", "http://", host, portPart, ctx, "");
            LOGGER.info(message);

        }else if(event instanceof ServletWebServerInitializedEvent){
            applicationContext = ( ( ServletWebServerInitializedEvent ) event ).getApplicationContext ();
            System.out.println("MailSender开始发送邮件");
            MailSendEvent mailSendEvent = new MailSendEvent(applicationContext, "武汉");
            applicationContext.publishEvent (mailSendEvent);
            
        }
       
    }

}
