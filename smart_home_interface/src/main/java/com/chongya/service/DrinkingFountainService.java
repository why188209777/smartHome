package com.chongya.service;

import com.chongya.entity.Drinking_fountain;

import java.util.List;

public interface DrinkingFountainService {

    //取数据
    public List<Drinking_fountain> getDfList();
    //增
    public int addDf(Drinking_fountain df);
    //删
    public int delDf(int did);
    //改
    public int updateDf(Drinking_fountain df);
    //查
    public Drinking_fountain getDfBydid(int did);
}
