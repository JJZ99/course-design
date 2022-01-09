package com.zhaojunjie.bean;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class TbTemperature implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String value;

    private String time;

    public TbTemperature(String s, String currTimeStampe) {
        value = s;
        time = currTimeStampe;
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

    public static TbTemperature getTemper() {
        return new TbTemperature("54", DateUtil.getCurrTimeStampe());
    }

    public static TbTemperature jsonToTemperature(String jsonString){
        return JSON.parseObject(jsonString).toJavaObject(TbTemperature.class);
    }
    @Override
    public String toString() {
        return "TbTemperature{" +
        "uid=" + uid +
        ", value=" + value +
        ", time=" + time +
        "}";
    }
}
