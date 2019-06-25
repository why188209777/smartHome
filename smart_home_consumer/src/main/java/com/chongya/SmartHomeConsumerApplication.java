package com.chongya;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubboConfiguration  //启用dubbo配置
public class SmartHomeConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartHomeConsumerApplication.class, args);
    }

}
