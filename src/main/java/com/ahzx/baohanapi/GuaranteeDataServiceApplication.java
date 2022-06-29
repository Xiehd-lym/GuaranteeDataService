package com.ahzx.baohanapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan//Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册
public class GuaranteeDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuaranteeDataServiceApplication.class, args);
    }
}
