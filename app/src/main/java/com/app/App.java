package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author JiaZM
 * @version V1.0
 * @date 2020/4/8
 */
@SpringBootApplication(scanBasePackages = {"com.app", "com.common"},
        exclude = {DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.app", "com.common"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
