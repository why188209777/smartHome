package com.chongya.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chongya.entity.Tv;
import com.chongya.mapper.TvMapper;
import com.chongya.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version="1.0.0",interfaceClass= TvService.class)
@org.springframework.stereotype.Service
public class TvServiceImpl implements TvService {

    @Autowired
    private TvMapper tvMapper;
    @Override
    public Tv getTvByTid(int tid) {
        return tvMapper.selectById(tid);
    }

    @Override
    public List<Tv> getTvList() {
        return tvMapper.selectList(null);
    }

}
