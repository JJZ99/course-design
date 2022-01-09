package com.zhaojunjie.service.impl;

import com.zhaojunjie.bean.TbHumiture;
import com.zhaojunjie.bean.TbTemperature;
import com.zhaojunjie.mapper.TbHumitureMapper;
import com.zhaojunjie.service.TbHumitureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjj
 * @since 2022-01-09
 */
@Service
public class TbHumitureServiceImpl extends ServiceImpl<TbHumitureMapper, TbHumiture> implements TbHumitureService {
    @Autowired
    private TbHumitureMapper tbHumitureMapper;

    @Override
    public List<TbHumiture> findAll() {
        return tbHumitureMapper.selectAll();
    }

    @Override
    public int inquireMaxUid() {
        return tbHumitureMapper.inquireMaxUid();
    }

    @Override
    public int insertItems(List list) {
        //获取迭代器对象
        try {
            Iterator<TbHumiture> it=list.iterator();
            while(it.hasNext()) {
                tbHumitureMapper.insert(it.next());
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return 0;
        }
        return 1;
    }
}
