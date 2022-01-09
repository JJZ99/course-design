package com.zhaojunjie.controller;


import com.zhaojunjie.bean.TbTemperature;
import com.zhaojunjie.service.TbTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjj
 * @since 2022-01-09
 */
@RestController
@RequestMapping("/tem")
public class TbTemperatureController {

    @Autowired
    private TbTemperatureService tbService;

    @RequestMapping("/get/all")
    public List<TbTemperature> findAll(){
        return tbService.findAll();
    }
    @RequestMapping("/insert/one")
    public int insertItem() throws Exception {

        return tbService.getBaseMapper().insert(TbTemperature.getTemper());
    }
}

