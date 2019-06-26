package com.chongya;

import com.chongya.entity.Air_conditioning;
import com.chongya.service.AirConditioningService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmartHomeProviderApplicationTests {

    @Autowired
    private AirConditioningService service;

    @Test
    public void contextLoads() {

    }

}
