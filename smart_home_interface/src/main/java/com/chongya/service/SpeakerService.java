package com.chongya.service;

import com.chongya.entity.Speaker;

import java.util.List;

public interface SpeakerService {
    public int addSpeaker(Speaker speaker);

    public int delSpeaker(int sid);

    public int updateSpeaker(Speaker speaker);

    public Speaker getSpeakerBySid(int sid);

    public List<Speaker> getAllSpeaker();
}
