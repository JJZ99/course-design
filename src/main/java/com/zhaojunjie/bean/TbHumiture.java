package com.zhaojunjie.bean;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-01-07
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbHumiture implements Serializable {


    private static final long serialVersionUID=1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String temperature;

    private String humidity;

    private String time;

    public TbHumiture(String s, String s1, String currDate) {
        temperature = s;
        humidity = s1;
        time = currDate;
    }

    public TbHumiture(int i, String s, String s1, String currDate) {
        uid = i;
        temperature = s;
        humidity = s1;
        time = currDate;
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TbHumiture{" +
        "uid=" + uid +
        ", temperature=" + temperature +
        ", humidity=" + humidity +
        ", time=" + time +
        "}";

    }
}
