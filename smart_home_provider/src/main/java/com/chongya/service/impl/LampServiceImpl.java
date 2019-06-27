package com.chongya.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chongya.entity.Lamp;
import com.chongya.mapper.LampMapper;
import com.chongya.service.LampService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0",interfaceClass = LampService.class)
@org.springframework.stereotype.Service
public class LampServiceImpl implements LampService {

    @Autowired
    private LampMapper mapper;
    @Override
    public List<Lamp> getLampList() {
        return mapper.selectList(null);
    }

    @Override
    public int addLamp(Lamp lamp) {
        return mapper.insert(lamp);
    }

    @Override
    public int delLamp(int lid) {
        return mapper.deleteById(lid);
    }

    @Override
    public int updateLamp(Lamp lamp) {
        return mapper.updateById(lamp);
    }

    @Override
    public Lamp getLampBylid(int lid) {
        return mapper.selectById(lid);
    }
}
