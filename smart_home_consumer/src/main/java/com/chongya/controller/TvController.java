package com.chongya.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chongya.entity.Tv;
import com.chongya.service.TvService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TvController {
    @Reference(version="1.0.0")
    private TvService tvService;

    @RequestMapping("getTvByTid/{tid}")
    public Tv getTvByTid(@PathVariable("tid") int tid){
        return tvService.getTvByTid(tid);
    }

    @RequestMapping("getTvList")
    public List<Tv> getTvList(){
        return  tvService.getTvList();
    }
}
