package com.bysj.qiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
public class QiuApplication {

    public static void main(String[] args) {
        SpringApplication.run(QiuApplication.class, args);
    }

}
