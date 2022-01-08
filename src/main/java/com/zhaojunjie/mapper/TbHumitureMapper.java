package com.zhaojunjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaojunjie.bean.TbHumiture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbHumitureMapper extends BaseMapper<TbHumiture> {
    List<TbHumiture> selectAll();
    TbHumiture selectById(int id) ;
    int insertItem(TbHumiture humiture) ;
    int inquireMaxUid();
}
