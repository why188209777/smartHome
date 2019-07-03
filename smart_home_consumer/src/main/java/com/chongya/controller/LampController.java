package com.chongya.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.chongya.entity.Lamp;
import com.chongya.service.LampService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class LampController {

    @Reference(version = "1.0.0")
    private LampService lampService;

    @RequestMapping("getLampList")
    public List<Lamp> getLampList(){
        return lampService.getLampList();
    }

    @RequestMapping("addLamp")
    public int addLamp(Lamp lamp){
        lamp = new Lamp();
        lamp.setLname("施华洛世奇水晶灯");
        lamp.setMode(1);
        lamp.setConnect_status(0);
        return lampService.addLamp(lamp);
    }

    @RequestMapping("delLamp/{lid}")
    public int delLamp(@PathVariable("lid") int lid){
        return lampService.delLamp(lid);
    }

    @RequestMapping("updateLamp")
    public int updateLamp(Lamp lamp){
        return lampService.updateLamp(lamp);
    }

    @RequestMapping("getLampBylid/{lid}")
    public Lamp getLampBylid(@PathVariable("lid") int lid){
        return lampService.getLampBylid(lid);
    }
}
