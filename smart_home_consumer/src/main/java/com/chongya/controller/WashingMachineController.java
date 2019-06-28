package com.chongya.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chongya.entity.Washing_machine;
import com.chongya.service.WashingMachineService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin
public class WashingMachineController {
    @Reference(version = "1.0.0")
    private WashingMachineService washingMachineService;

        @RequestMapping("addWM")
    public int addWM(Washing_machine washing_machine) {
     /*   washing_machine.setTime(50);
        washing_machine.setWname("awa");
        washing_machine.setMode(1);
        washing_machine.setConnect_status(1);
        washing_machine.setSwitch_status(1);*/
        return washingMachineService.addWM(washing_machine);
    }

    @RequestMapping("delWM/{wid}")
    public int delWM(@PathVariable("wid") int wid) {
        return washingMachineService.delWM(wid);
    }

    @RequestMapping("updateWM")
    public int updateWM(Washing_machine washing_machine) {
       /* washing_machine.setSwitch_status(1);
        washing_machine.setConnect_status(1);
        washing_machine.setMode(2);
        washing_machine.setWname("xiaac");
        washing_machine.setTime(20);
        washing_machine.setWid(1);*/
        return washingMachineService.updateWM(washing_machine);
    }

    @RequestMapping("getWMByWid/{wid}")
    public Washing_machine getWMByWid(@PathVariable("wid") int wid){
        return washingMachineService.getWMByWid(wid);
    }

    @RequestMapping("getWMList")
    public List<Washing_machine> getWMList() {
        return washingMachineService.getWMList();
    }
}
