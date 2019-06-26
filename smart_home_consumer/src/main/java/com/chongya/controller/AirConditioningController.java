package com.chongya.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chongya.entity.Air_conditioning;
import com.chongya.service.AirConditioningService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirConditioningController {
    @Reference(version = "1.0.0")
    private AirConditioningService acs;

    @RequestMapping("getAcList")
    public List<Air_conditioning> getAcList(){
        return  acs.getAcList();
    }

    @RequestMapping("addAc")
    public int addAc(Air_conditioning ac){
        Air_conditioning conditioning = new Air_conditioning();
        conditioning.setAname("海克斯空调");
        conditioning.setTemp(25);
        conditioning.setMode(0);
        conditioning.setSpeed(0);
        conditioning.setTime(3000);
        conditioning.setDirection(0);
        conditioning.setSwitch_status(0);
        conditioning.setConnect_status(0);
        return  acs.addAc(conditioning);
    }
    @RequestMapping("updateAid")
    public  int updateAc(Air_conditioning ac){
        Air_conditioning conditioning = new Air_conditioning();
        conditioning.setAname("水院空调");
        conditioning.setAid(1);
        return acs.updateAc(conditioning);
    }


}
