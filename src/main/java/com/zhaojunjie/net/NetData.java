package com.zhaojunjie.net;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhaojunjie.baseParam.ApiParam;
import com.zhaojunjie.baseParam.CommonPairs;
import com.zhaojunjie.bean.TbHumiture;
import com.zhaojunjie.bean.TbTemperature;
import com.zhaojunjie.service.TbHumitureService;
import com.zhaojunjie.service.TbTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NetData {
    @Autowired
    TbHumitureService tbHumitureService;
    @Autowired
    TbTemperatureService tbTemperatureService;

    RestMock restMock = new RestMock();
    public void getNetData() {
        Map<String, String> mapParam = new HashMap<>();
        mapParam.put(CommonPairs.KEY_ACCESS_TOKEN, CommonPairs.VALUE_ACCESS_TOKEN);
        mapParam.put(CommonPairs.KEY_ID, CommonPairs.VALUE_TEMP_DEVICE_ID);

        //获取湿度数据
        String humituresJsonString = restMock.sendGet(ApiParam.PROTOCOL_HTTPS, ApiParam.BASE_URL, mapParam);
        JSONArray jsonObject = JSON.parseArray(humituresJsonString);
        List<TbHumiture> tbHumitures = new ArrayList<>();
        for (int i = 0; i <jsonObject.size() ; i++) {
            System.out.println("key值="+jsonObject.get(i));
            tbHumitures.add(TbHumiture.jsonToTemperature(jsonObject.get(i).toString()));
        }
        tbHumitureService.insertItems(tbHumitures);

        //获取温度数据
        mapParam.put(CommonPairs.KEY_ID, CommonPairs.VALUE_HUM_DEVICE_ID);
        String temperatureJsonString = restMock.sendGet(ApiParam.PROTOCOL_HTTPS, ApiParam.BASE_URL, mapParam);
        JSONArray json2Object = JSON.parseArray(temperatureJsonString);
        List<TbTemperature> tbTemperatures = new ArrayList<>();
        for (int i = 0; i <json2Object.size() ; i++) {
            System.out.println("key值="+json2Object.get(i));
            tbTemperatures.add(TbTemperature.jsonToTemperature(jsonObject.get(i).toString()));
        }
        tbTemperatureService.insertItems(tbTemperatures);

    }

    public List<Class> jsonStringToList(Class e,String arrayString){

        return null;
    }
}
