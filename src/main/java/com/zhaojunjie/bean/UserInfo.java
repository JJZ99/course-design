package com.zhaojunjie.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {
    String uid;
    String nickname; //用户名
    String level; //用户等级
    String score;  //用户积分
    String online;  //在线状态，0：不在线，1：在线
    String image;  //头像代码，可用于获取头像
}
