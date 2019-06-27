package com.chongya.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chongya.entity.Air_conditioning;
import com.chongya.mapper.AirConditioningMapper;
import com.chongya.service.AirConditioningService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(version = "1.0.0",interfaceClass = AirConditioningService.class)
@org.springframework.stereotype.Service
public class AirConditioningServiceImpl implements AirConditioningService {

    @Autowired
    private AirConditioningMapper mapper;
    @Override
    public List<Air_conditioning> getAcList() {
        return mapper.selectList(null);
    }

    @Override
    public int addAc(Air_conditioning ac) {
        return mapper.insert(ac);
    }

    @Override
    public int delAc(int aid) {
        return mapper.deleteById(aid);
    }

    @Override
    public int updateAc(Air_conditioning ac) {
        return mapper.updateById(ac);
    }

    @Override
    public Air_conditioning getAcByAid(int aid) {
        return mapper.selectById(aid);
    }
}
