package com.zhaojunjie.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    /**
     * 获取当前的时间
     * @return
     */
    public static String getCurrDate(){
        Date d = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
    }

    /**
     * 获取当前的时间戳string
     * @return
     */
    public static String getCurrTimeStampe(){
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 年月日时间转化为时间戳string
     * @param dateString
     * @return
     */
    public static String dateToTimeStamp(String dateString){
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        System.out.println(ts);
        return String.valueOf(ts);
    }

    /**
     * 时间戳转化为年月日分秒
     * @param timeStamp
     * @return
     */
    public static String timeStampToDate(Long timeStamp){
        Date date = new Date(timeStamp);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
