package com.zhaojunjie.baseParam;

public interface ApiParam {

    public static String PROTOCOL_HTTPS= "https"; //网络协议
    public static String BASE_URL = "www.bigiot.net/oauth";
    public static String HISTORY_PATH = BASE_URL + "/historydata"; //历史数据
    public static String IMPUT_PATH = BASE_URL + "/myinputs"; //用户数据接口
    public static String DELETE_HISTORY_PATH = BASE_URL + "/delete_history_data"; //清除历史数据
    public static String USER_INFO_PATH = BASE_URL + "/userinfo"; //用户信息
}
