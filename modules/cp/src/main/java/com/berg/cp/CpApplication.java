package com.berg.cp;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@ComponentScan("com.berg")
public class CpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpApplication.class, args);
    }

}
