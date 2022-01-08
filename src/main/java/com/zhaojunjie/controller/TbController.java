package com.zhaojunjie.controller;

import com.zhaojunjie.bean.TbHumiture;
import com.zhaojunjie.service.TbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class TbController {

    @Autowired
    private TbService tbService;

    @RequestMapping("/get/all")
    @ResponseBody
    public List<TbHumiture> findAll(){
        return tbService.findAll();
    }
    @RequestMapping("/insert/one")
    @ResponseBody
    public int insertItem() throws Exception {
        return tbService.insertItem();
    }

}
