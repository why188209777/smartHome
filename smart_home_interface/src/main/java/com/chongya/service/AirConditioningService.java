package com.chongya.service;


import com.chongya.entity.Air_conditioning;

import java.util.List;

public interface AirConditioningService {
    //取数据
    public List<Air_conditioning> getAcList();
    //增
    public int addAc(Air_conditioning ac);
    //删
    public int delAc(int aid);
    //改
    public int updateAc(Air_conditioning ac);
    //查
    public Air_conditioning getAcByid(int aid);
}
