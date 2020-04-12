package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author JiaZM
 * @version V1.0
 * @date 2020/4/8
 */
@SpringBootApplication(scanBasePackages = {"com.server", "com.common"})
@ComponentScan(basePackages = {"com.server", "com.common"})
@EntityScan(basePackages = "com.common")
public class Server {
    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
}
