package com.chongya.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chongya.entity.Refrigerator;
import com.chongya.mapper.RefrigeratorMapper;
import com.chongya.service.RefrigeratorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(version="1.0.0",interfaceClass= RefrigeratorService.class)
@org.springframework.stereotype.Service
public class RefrigeratorServiceImpl implements RefrigeratorService {
    @Autowired
    private RefrigeratorMapper refrigeratorMapper;
    @Override
    public int addRefrigerator(Refrigerator refrigerator) {
        return refrigeratorMapper.insert(refrigerator);
    }

    @Override
    public int delRefrigerator(int rid) {
        return refrigeratorMapper.deleteById(rid);
    }

    @Override
    public int updateRefrigerator(Refrigerator refrigerator) {
        return refrigeratorMapper.updateById(refrigerator);
    }

    @Override
    public Refrigerator getRefrigeratorByRid(int rid) {
        return refrigeratorMapper.selectById(rid);
    }

    @Override
    public List<Refrigerator> getAllRefrigerator() {
        return refrigeratorMapper.selectList(null);
    }
}
