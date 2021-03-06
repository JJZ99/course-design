package com.zhaojunjie.bean;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.xml.internal.ws.developer.Serialization;
import com.zhaojunjie.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zjj
 * @since 2022-01-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbHumiture implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String value;

    private String time;

    public TbHumiture(int i, String s,String currDate) {
        uid = i;
        value = s;
        time = currDate;
    }

    public TbHumiture(String s, String currDate) {
        value = s;
        time = currDate;
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static TbHumiture getHumiture(){
        return new TbHumiture("54", DateUtil.getCurrTimeStampe());
    }

    public static TbHumiture jsonToTemperature(String jsonString){
        return JSON.parseObject(jsonString).toJavaObject(TbHumiture.class);
    }

    @Override
    public String toString() {
        return "TbHumiture{" +
        "uid=" + uid +
        ", value=" + value +
        ", time=" + time +
        "}";
    }
}
