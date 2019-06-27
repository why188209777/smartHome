package com.chongya.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chongya.entity.Drinking_fountain;
import com.chongya.mapper.DrinkingFountainMapper;
import com.chongya.service.DrinkingFountainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0",interfaceClass = DrinkingFountainService.class)
@org.springframework.stereotype.Service
public class DrinkingFountainServiceImpl implements DrinkingFountainService {

    @Autowired
    private DrinkingFountainMapper mapper;
    @Override
    public List<Drinking_fountain> getDfList() {
        return mapper.selectList(null);
    }

    @Override
    public int addDf(Drinking_fountain df) {
        return mapper.insert(df);
    }

    @Override
    public int delDf(int did) {
        return mapper.deleteById(did);
    }

    @Override
    public int updateDf(Drinking_fountain df) {
        return mapper.updateById(df);
    }

    @Override
    public Drinking_fountain getDfBydid(int did) {
        System.out.println(mapper.selectById(did));
        return mapper.selectById(did);

    }
}
