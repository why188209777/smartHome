package com.chongya.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chongya.entity.Drinking_fountain;
import com.chongya.service.DrinkingFountainService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DrinkingFountainController {

    @Reference(version = "1.0.0")
    private DrinkingFountainService dfs;

    @RequestMapping("getDfList")
    public List<Drinking_fountain> getDfList(){
        return dfs.getDfList();
    }
    @RequestMapping("addDf")
    public int addDf(Drinking_fountain df){
        df = new Drinking_fountain();
        df.setDname("西门子饮水机");
        df.setConnect_status(0);
        df.setMode(1);
        df.setSwitch_status(0);
        return dfs.addDf(df);
    }
    @RequestMapping("delDf/{did}")
    public int delDf(@PathVariable("did") int did){
        return dfs.delDf(did);
    }
    @RequestMapping("updateDf")
    public int updateDf(Drinking_fountain df){
        /*df = new Drinking_fountain();
        df.setDname("水院饮水机");
        df.setConnect_status(0);
        df.setDid(1);
        df.setMode(1);
        df.setSwitch_status(1);*/
        return dfs.updateDf(df);
    }
    @RequestMapping("getDfBydid/{did}")
    public Drinking_fountain getDfBydid(@PathVariable("did") int did){
        return dfs.getDfBydid(did);
    }

}
