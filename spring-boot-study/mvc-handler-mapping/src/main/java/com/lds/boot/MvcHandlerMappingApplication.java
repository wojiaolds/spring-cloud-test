package com.lds.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
/**
 * 用@Order注解（或者实现Order接口）来规定所有CommandLineRunner实例的运行顺序。
 */
@Order (value=1)
public class MvcHandlerMappingApplication implements CommandLineRunner{
    
    @Autowired
    private DataSource dataSource;
    
    public static void main(String[] args) {
        SpringApplication.run(MvcHandlerMappingApplication.class, args);
    }
    
    @Override
    public void run ( String... args ) throws Exception {
    
        System.out.println("DATASOURCE = " + dataSource);
        Stream.of (args).forEach (System.out::println);
//        Arrays.asList (args).forEach (System.out::println);
        System.out.println(CommandLineRunner.class.isAssignableFrom (MvcHandlerMappingApplication.class));
    }
}
