package com.zhaojunjie;

import com.zhaojunjie.net.NetData;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Coursedesignv2Application {

    public static void main(String[] args) {
        SpringApplication.run(Coursedesignv2Application.class, args);
        NetData netData = new NetData();
        netData.getNetData();

    }

}
