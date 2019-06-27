package com.chongya.service;

import com.chongya.entity.Lamp;

import java.util.List;

public interface LampService {

    //取数据
    public List<Lamp> getLampList();
    //增
    public int addLamp(Lamp lamp);
    //删
    public int delLamp(int lid);
    //改
    public int updateLamp(Lamp lamp);
    //查
    public Lamp getLampBylid(int lid);
}
