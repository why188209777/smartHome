package com.chongya.service;

import com.chongya.entity.Refrigerator;

import java.util.List;

public interface RefrigeratorService {
    public int addRefrigerator(Refrigerator refrigerator);

    public int delRefrigerator(int rid);

    public int updateRefrigerator(Refrigerator refrigerator);

    public Refrigerator getRefrigeratorByRid(int rid);

    public List<Refrigerator> getAllRefrigerator();
}

