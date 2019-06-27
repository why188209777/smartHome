package com.chongya.service;

import com.chongya.entity.Washing_machine;

import java.util.List;

public interface WashingMachineService {
    public int addWM(Washing_machine washing_machine);
    public int delWM(int wid);
    public int updateWM(Washing_machine washing_machine);
    public Washing_machine getWMByWid(int wid);
    public List<Washing_machine> getWMList();
}
