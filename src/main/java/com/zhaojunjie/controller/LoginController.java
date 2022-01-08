package com.zhaojunjie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLogin(){
        return "login";
    }
    @RequestMapping("/showIndex")
    public String showIndex(Map<String,Object> map){
        map.put("msg","testMessage");
        return "index";
    }
}
