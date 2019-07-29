package com.lds.example.springcloudconsulconsumer.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyContextListener {

    private static int counter;

    @Autowired
    private ServerProperties serverProperties;

    @EventListener
    public void handle(Object event) throws IOException {
        System.out.println("*********" + (++counter) + ": " + event.toString() + "*********");
        if(event instanceof ApplicationReadyEvent){

            System.out.println("应用已经准备就绪 ... 启动浏览器");
            String url = "http://localhost:"+serverProperties.getPort()+"/services";
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
