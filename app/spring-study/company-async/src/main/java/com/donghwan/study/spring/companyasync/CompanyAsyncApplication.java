package com.donghwan.study.spring.companyasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CompanyAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyAsyncApplication.class, args);
    }

}
