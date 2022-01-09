package com.zhaojunjie.bean;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseErrorStatus implements Serializable {
    @SerializedName("error")
    String error;
}
