package com.chongya;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chongya.mapper")
@EnableDubboConfiguration   //开启dubbo服务
public class SmartHomeProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartHomeProviderApplication.class, args);
    }

}
