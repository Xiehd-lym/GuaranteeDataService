package com.ahzx.baohanapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.ahzx.baohanapi.mapper"})
public class GuaranteeDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuaranteeDataServiceApplication.class, args);
    }

}
