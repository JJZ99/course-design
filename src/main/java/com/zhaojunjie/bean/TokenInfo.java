package com.zhaojunjie.bean;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfo implements Serializable {

    @SerializedName("access_token")
    String accessToken; //获取网站资源凭证
    @SerializedName("expires_in")
    String expiresIn; //凭证有效时间，单位秒
    @SerializedName("token_type")
    String tokenType;  //凭证类型
    @SerializedName("scope")
    String scope; //备用字段
    @SerializedName("refresh_token")
    String refreshToken;//刷新当前token凭证，可用于延期当前凭证（暂不可用）

}
