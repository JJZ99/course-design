package com.zhaojunjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaojunjie.bean.TbHumiture;
import com.zhaojunjie.mapper.TbHumitureMapper;
import com.zhaojunjie.service.TbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.zhaojunjie.util.DateUtil.getCurrDate;
import static com.zhaojunjie.util.DateUtil.getCurrTimeStampe;

@Service
public class TbServiceImpl extends ServiceImpl<TbHumitureMapper, TbHumiture> implements TbService {
    @Autowired
    private TbHumitureMapper tbHumitureMapper;

    @Override
    public List<TbHumiture> findAll() {
        return tbHumitureMapper.selectAll();
    }

    @Override
    public TbHumiture selectById(int id)  {
        return tbHumitureMapper.selectById(id);
    }

    @Override
    public int insertItem()  {
        //int maxUid = tbHumitureMapper.inquireMaxUid();

        TbHumiture humiture = new TbHumiture("35", getCurrTimeStampe());
        return tbHumitureMapper.insertItem(humiture);
    }

    @Override
    public int inquireMaxUid()  {
        return tbHumitureMapper.inquireMaxUid();
    }

}
