package com.zhaojunjie.service.impl;

import com.zhaojunjie.bean.TbTemperature;
import com.zhaojunjie.mapper.TbTemperatureMapper;
import com.zhaojunjie.service.TbTemperatureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

import static com.zhaojunjie.util.DateUtil.getCurrTimeStampe;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjj
 * @since 2022-01-09
 */
@Service
public class TbTemperatureServiceImpl extends ServiceImpl<TbTemperatureMapper, TbTemperature> implements TbTemperatureService {

    @Autowired
    TbTemperatureMapper tbTemperatureMapper;

    @Override
    public List<TbTemperature> findAll() {
        return tbTemperatureMapper.selectAll();
    }

    @Override
    public int inquireMaxUid() {
        return tbTemperatureMapper.inquireMaxUid();
    }

    @Override
    public int insertItems(List list) {
        //获取迭代器对象
        try {
            Iterator<TbTemperature> it=list.iterator();
            while(it.hasNext()) {
                tbTemperatureMapper.insert(it.next());
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return 0;
        }
        return 1;
    }
//
//    public int insert(){
//        return tbTemperatureMapper.insert(new TbTemperature(inquireMaxUid() + 1, "23", getCurrTimeStampe()));
//    }
}
