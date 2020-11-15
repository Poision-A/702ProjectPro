package com.example.upload702;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.upload702.mapper")
public class Upload702Application {

    public static void main(String[] args) {
        SpringApplication.run(Upload702Application.class, args);
    }

}
