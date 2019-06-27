package com.chongya.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chongya.entity.Speaker;
import com.chongya.service.SpeakerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class SpeakerController {
    @Reference(version="1.0.0")
    private SpeakerService speakerService;
    @RequestMapping("addSpeaker")
    public int addSpeaker(Speaker speaker) {
      /*  speaker = new Speaker();
        speaker.setSname("gjhgjh");
        speaker.setConnect_status(0);
        speaker.setSwitch_status(0);*/
        return speakerService.addSpeaker(speaker);
    }
    @RequestMapping("delSpeaker")
    public int delSpeaker(int sid){
        return speakerService.delSpeaker(sid);
    }
    @RequestMapping("updatSpeaker")
    public int updatSpeaker(Speaker speaker){
       /* speaker.setSid(2);
        speaker.setSname("mama");
        speaker.setSwitch_status(0);
        speaker.setConnect_status(1);*/
        return speakerService.updateSpeaker(speaker);
    }
    @RequestMapping("getSpeakerBySid")
    public Speaker getSpeakerBySid(int sid){
        return speakerService.getSpeakerBySid(sid);
    }
    @RequestMapping("getAllSpeaker")
    public List<Speaker> getAllSpeaker(){
        return speakerService.getAllSpeaker();
    }
}
