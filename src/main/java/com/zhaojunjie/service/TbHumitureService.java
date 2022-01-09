package com.zhaojunjie.service;

import com.zhaojunjie.bean.TbHumiture;
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
public interface TbHumitureService extends IService<TbHumiture> {
    public List<TbHumiture> findAll();
    public int inquireMaxUid() ;
    public int insertItems(List list);
}
