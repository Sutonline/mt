package com.mt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author yongkang.zhang
 * created at 04/08/2018
 */
@SpringBootApplication
public class ManApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ManApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ManApplication.class, args);
    }
}
