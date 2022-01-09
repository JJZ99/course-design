package com.zhaojunjie.mapper;

import com.zhaojunjie.bean.TbHumiture;
import com.zhaojunjie.bean.TbTemperature;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zjj
 * @since 2022-01-09
 */
@Mapper
public interface TbTemperatureMapper extends BaseMapper<TbTemperature> {
    List<TbTemperature> selectAll();
    int inquireMaxUid();
}
