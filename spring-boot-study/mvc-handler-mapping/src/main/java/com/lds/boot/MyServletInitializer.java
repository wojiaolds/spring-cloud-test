package com.lds.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class MyServletInitializer extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(MvcHandlerMappingApplication.class);
    }

}
