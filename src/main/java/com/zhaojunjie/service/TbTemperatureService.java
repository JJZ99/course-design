package com.zhaojunjie.service;

import com.zhaojunjie.bean.TbHumiture;
import com.zhaojunjie.bean.TbTemperature;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zjj
 * @since 2022-01-09
 */
public interface TbTemperatureService extends IService<TbTemperature> {
    public List<TbTemperature> findAll();
    public int inquireMaxUid() ;
    public int insertItems(List list);

}
