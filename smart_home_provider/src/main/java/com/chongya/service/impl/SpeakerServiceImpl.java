package com.chongya.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chongya.entity.Speaker;
import com.chongya.mapper.SpeakerMapper;
import com.chongya.mapper.TvMapper;
import com.chongya.service.SpeakerService;
import com.chongya.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(version="1.0.0",interfaceClass= SpeakerService.class)
@org.springframework.stereotype.Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerMapper speakerMapper;
    @Override
    public int addSpeaker(Speaker speaker) {
        return speakerMapper.insert(speaker);
    }

    @Override
    public int delSpeaker(int sid) {
        return speakerMapper.deleteById(sid);
    }

    @Override
    public int updateSpeaker(Speaker speaker) {
        return speakerMapper.updateById(speaker);
    }

    @Override
    public Speaker getSpeakerBySid(int sid) {
        return speakerMapper.selectById(sid);
    }

    @Override
    public List<Speaker> getAllSpeaker() {
        return speakerMapper.selectList(null);
    }
}
