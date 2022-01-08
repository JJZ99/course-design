package com.zhaojunjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaojunjie.bean.TbHumiture;

import java.util.List;

public interface TbService extends IService<TbHumiture> {
    public List<TbHumiture> findAll();
    TbHumiture selectById(int id) ;
    int insertItem() ;
    int inquireMaxUid() ;
}

