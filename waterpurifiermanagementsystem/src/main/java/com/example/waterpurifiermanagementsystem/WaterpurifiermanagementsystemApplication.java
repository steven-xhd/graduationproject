package com.example.waterpurifiermanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.waterpurifiermanagementsystem.mapper")
public class WaterpurifiermanagementsystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(WaterpurifiermanagementsystemApplication.class, args);
    }

}
