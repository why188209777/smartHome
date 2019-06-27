package com.chongya.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chongya.entity.Washing_machine;
import com.chongya.mapper.WashingMachineMapper;
import com.chongya.service.WashingMachineService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(version="1.0.0",interfaceClass= WashingMachineService.class)
@org.springframework.stereotype.Service
public class WashingMachineServiceImpl implements WashingMachineService {
    @Autowired
    private WashingMachineMapper washingMachineMapper;
    @Override
    public int addWM(Washing_machine washing_machine) {
        return washingMachineMapper.insert(washing_machine);
    }

    @Override
    public int delWM(int wid) {
        return washingMachineMapper.deleteById(wid);
    }

    @Override
    public int updateWM(Washing_machine washing_machine) {
        return washingMachineMapper.updateById(washing_machine);
    }

    @Override
    public Washing_machine getWMByWid(int wid) {
        return washingMachineMapper.selectById(wid);
    }

    @Override
    public List<Washing_machine> getWMList() {
        return washingMachineMapper.selectList(null);
    }
}
