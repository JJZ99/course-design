package com.zhaojunjie.net;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhaojunjie.baseParam.ApiParam;
import com.zhaojunjie.baseParam.CommonPairs;
import com.zhaojunjie.bean.TbHumiture;
import com.zhaojunjie.bean.TbTemperature;
import com.zhaojunjie.mapper.TbHumitureMapper;
import com.zhaojunjie.mapper.TbTemperatureMapper;
import com.zhaojunjie.pool.MyConnectionPool;
import com.zhaojunjie.service.TbHumitureService;
import com.zhaojunjie.service.TbTemperatureService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static com.zhaojunjie.baseParam.ApiParam.HISTORY_PATH;
import static com.zhaojunjie.baseParam.ApiParam.PROTOCOL_HTTPS;
import static com.zhaojunjie.util.DateUtil.getCurrTimeStampe;

@Component
public class NetData {

//    private SqlSessionFactory factory;
//    {
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        factory = builder.build(inputStream);
//    }

    @Autowired
    RestMock restMock = new RestMock();
    public void getNetData() {
        Map<String, String> mapParam = new HashMap<>();
        mapParam.put(CommonPairs.KEY_ACCESS_TOKEN, CommonPairs.VALUE_ACCESS_TOKEN);
        mapParam.put(CommonPairs.KEY_ID, CommonPairs.VALUE_TEMP_DEVICE_ID);

        //获取湿度数据
        String humituresJsonString = restMock.sendGet(PROTOCOL_HTTPS, HISTORY_PATH, mapParam);
        JSONArray jsonObject = JSON.parseArray(humituresJsonString);
        List<TbHumiture> tbHumitures = new ArrayList<>();
        for (int i = 0; i <jsonObject.size() ; i++) {
            System.out.println("key值="+jsonObject.get(i));
            tbHumitures.add(TbHumiture.jsonToTemperature(jsonObject.get(i).toString()));
        }
        insertHumItemsJDBC(tbHumitures);


        //获取温度数据
        mapParam.put(CommonPairs.KEY_ID, CommonPairs.VALUE_HUM_DEVICE_ID);
        String temperatureJsonString = restMock.sendGet(PROTOCOL_HTTPS, HISTORY_PATH, mapParam);
        JSONArray json2Object = JSON.parseArray(temperatureJsonString);
        List<TbTemperature> tbTemperatures = new ArrayList<>();
        for (int i = 0; i <json2Object.size() ; i++) {
            System.out.println("key值="+json2Object.get(i));
            tbTemperatures.add(TbTemperature.jsonToTemperature(jsonObject.get(i).toString()));
        }
        insertTemItemsJDBC(tbTemperatures);

    }

    public int insertHumItemsJDBC(List<TbHumiture> list) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        try{
            connection = MyConnectionPool.getConnection();
            String sql="insert into tb_humiture(uid,value,time) values (DEFAULT ,?,?)";
            preparedStatement = connection.prepareStatement(sql);//这里已经传入SQL语句

            for (int i = 0; i < list.size(); i++) {
                preparedStatement.setString(1, list.get(i).getValue());
                preparedStatement.setString(2, list.get(i).getTime());
                preparedStatement.addBatch();// 将修改放入一个批次中
                if (i % 50 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();// 清除批处理中的数据
                }
            }
            /*
             * 整数数组中的元素代表执行的结果代号
             * SUCCESS_NO_INFO -2
             * EXECUTE_FAILED  -3
             * */
            /*int[] ints = */
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 1;
    }
    public int insertTemItemsJDBC(List<TbTemperature> list) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        try{
            connection = MyConnectionPool.getConnection();
            String sql="insert into tb_temperature(uid,value,time) values (DEFAULT ,?,?)";
            preparedStatement = connection.prepareStatement(sql);//这里已经传入SQL语句

            for (int i = 0; i < list.size(); i++) {
                preparedStatement.setString(1, list.get(i).getValue());
                preparedStatement.setString(2, list.get(i).getTime());
                preparedStatement.addBatch();// 将修改放入一个批次中
                if (i % 50 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();// 清除批处理中的数据
                }
            }
            /*
             * 整数数组中的元素代表执行的结果代号
             * SUCCESS_NO_INFO -2
             * EXECUTE_FAILED  -3
             * */
            /*int[] ints = */
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 1;
    }


//    public int insertHumItems(List<TbHumiture> list) {
//        SqlSession session = factory.openSession();
//        TbHumitureMapper tbHumitureMapper = session.getMapper(TbHumitureMapper.class);
//        try {
//            Iterator<TbHumiture> it=list.iterator();
//            while(it.hasNext()) {
//                tbHumitureMapper.insertItem(it.next());
//            }
//        } finally {
//            session.close();
//            if (list != null) {
//                for (TbHumiture humiture : list) {
//                    System.out.println(humiture);
//                }
//            }
//        }
//        return 1;
//    }
//    public int insertTempItems(List<TbTemperature> list) {
//        SqlSession session = factory.openSession();
//        TbTemperatureMapper tbTemperatureMapper = session.getMapper(TbTemperatureMapper.class);
//        try {
//            Iterator<TbTemperature> it=list.iterator();
//            while(it.hasNext()) {
//                tbTemperatureMapper.insert(it.next());
//            }
//        } finally {
//            session.close();
//            if (list != null) {
//                for (TbTemperature tbTemperature : list) {
//                    System.out.println(tbTemperature);
//                }
//            }
//        }
//        return 1;
//    }
}
