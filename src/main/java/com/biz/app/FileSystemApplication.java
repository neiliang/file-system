package com.biz.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.biz"})
@MapperScan(basePackages = {"com.biz.dao"})
public class FileSystemApplication {




    public static void main(String[] args) {

        SpringApplication.run(FileSystemApplication.class, args);

    }





}
