package com.chongya.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chongya.entity.Refrigerator;
import com.chongya.service.RefrigeratorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RefrigeratorController {
    @Reference(version = "1.0.0")
    private RefrigeratorService refrigeratorService;

    @RequestMapping("addRefrigerator")
    public int addRefrigerator(Refrigerator refrigerator) {
        /*refrigerator.setRname("aaw");
        refrigerator.setGear(2);
        refrigerator.setSwitch_status(0);
        refrigerator.setConnect_status(0);*/
        return refrigeratorService.addRefrigerator(refrigerator);
    }

    @RequestMapping("delRefrigerator/{rid}")
    public int delRefrigerator(@PathVariable("rid") int rid) {
        return refrigeratorService.delRefrigerator(rid);
    }

    @RequestMapping("updateRefrigerator")
    public int updateRefrigerator(Refrigerator refrigerator) {
        /*refrigerator.setRid(1);
        refrigerator.setRname("假的海尔");
        refrigerator.setGear(3);
        refrigerator.setConnect_status(1);
        refrigerator.setSwitch_status(1);*/
        return refrigeratorService.updateRefrigerator(refrigerator);
    }

    @RequestMapping("getRefrigeratorByRid/{rid}")
    public Refrigerator getRefrigeratorByRid(@PathVariable("rid") int rid) {
        return refrigeratorService.getRefrigeratorByRid(rid);
    }
    @RequestMapping("getAllRefrigerator")
    public List<Refrigerator> getAllSpeaker(){
        return refrigeratorService.getAllRefrigerator();
    }

}



