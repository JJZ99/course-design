package com.zhaojunjie.controller;

import com.zhaojunjie.bean.TbHumiture;
import com.zhaojunjie.bean.TbTemperature;
import com.zhaojunjie.mapper.TbTemperatureMapper;
import com.zhaojunjie.service.TbHumitureService;
import com.zhaojunjie.service.TbService;
import com.zhaojunjie.service.TbTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Controller
public class TbController {
    @Autowired
    private TbHumitureService tbHumitureService;

    @Autowired
    private TbTemperatureService tbTemperatureService;

    @Autowired
    private TbService tbService;

    @RequestMapping("/get/all")
    @ResponseBody
    public List<TbHumiture> findAll(){
        return tbService.findAll();
    }
    @RequestMapping("/insert/one")
    public int insertItem() throws Exception {
        return tbService.insertItem();
    }

    @RequestMapping("/showAll")
    public String showAll(Map<String,Object> map) throws Exception {
        List<TbHumiture> tbHumitures = tbHumitureService.findAll();
        List<TbTemperature> tbTemperatures = tbTemperatureService.findAll();
        map.put("hums",tbHumitures);
        map.put("tems",tbTemperatures);
        return "showAll";
    }


}
