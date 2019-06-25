package com.chongya.service;

import com.chongya.entity.Tv;

import java.util.List;

public interface TvService {
    public Tv getTvByTid(int tid);
    public List<Tv> getTvList();
}
