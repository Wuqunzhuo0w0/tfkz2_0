package com.tfkz.tfkz2_0;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.tfkz.tfkz2_0.mapper")
public class Tfkz20Application {

    public static void main(String[] args) {
        SpringApplication.run(Tfkz20Application.class, args);
    }

}
