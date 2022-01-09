package com.zhaojunjie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhaojunjie.bean.TbHumiture;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestNet {
    private NetParam netParam = new NetParam();

    private static String URL = "www.bigiot.net/oauth/historydata?access_token=1bd62933e9c8ecaef85bf3cd09ac1b5d83547c45&id=22058";

    public RestTemplate restTemplate() {
        return new RestTemplate(httpRequestFactory());
    }
    public ClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(getClient());
    }

    @Test
    public void getNetData() throws Exception {
        RestTemplate restTemplate = restTemplate();


        ResponseEntity responseEntity = restTemplate.getForEntity
                (
                        generateRequestParameters("https", URL, null),
                        String.class
                );
        JSONArray jsonObject = new JSONArray(responseEntity.getBody().toString());
        //org.json.JSONObject解析方法

        for (int i = 0; i < jsonObject.length(); i++) {
            System.out.println("key值="+jsonObject.get(i));
            JSONObject json = JSON.parseObject(jsonObject.get(i).toString());
            System.out.println(json.toJavaObject(TbHumiture.class).toString());
           // System.out.println(new TbHumiture(json.optString("value"),json.optString("time")));
        }


        System.out.println(responseEntity.getBody().toString());
    }
    /**
     * 生成get参数请求url
     * 示例：https://0.0.0.0:80/api?u=u&o=o
     * 示例：https://0.0.0.0:80/api
     *
     * @param protocol 请求协议 示例: http 或者 https
     * @param uri      请求的uri 示例: 0.0.0.0:80
     * @param params   请求参数
     * @return
     */
    public String generateRequestParameters(String protocol, String uri, Map<String, String> params) {
        StringBuilder sb = new StringBuilder(protocol).append("://").append(uri);
        if (params!=null && params.size()>0) {
            sb.append("?");
            for (Map.Entry map : params.entrySet()) {
                sb.append(map.getKey())
                        .append("=")
                        .append(map.getValue())
                        .append("&");
            }
            uri = sb.substring(0, sb.length() - 1);
            return uri;
        }
        return sb.toString();
    }

    /**
     * get请求、请求参数为?拼接形式的
     * <p>
     * 最终请求的URI如下：
     * <p>
     * http://127.0.0.1:80/?name=张耀烽&sex=男
     *
     * @return
     */
    public String sendGet() {
        Map<String, String> uriMap = new HashMap<>(6);
        uriMap.put("name", "张耀烽");
        uriMap.put("sex", "男");
        RestTemplate restTemplate = restTemplate();

        ResponseEntity responseEntity = restTemplate.getForEntity
                (
                        generateRequestParameters("http", "127.0.0.1:80", uriMap),
                        String.class
                );
        return (String) responseEntity.getBody();
    }


    public HttpClient getClient(){
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(netParam.getMaxTotal());
        connectionManager.setDefaultMaxPerRoute(netParam.getMaxPerRoute());
        connectionManager.setValidateAfterInactivity(netParam.getInactivity());
        RequestConfig requestConfig = RequestConfig.custom()
                //服务器返回数据(response)的时间，超过抛出read timeout
                .setSocketTimeout(netParam.getSocketTimeout())
                //连接上服务器(握手成功)的时间，超出抛出connect timeout
                .setConnectTimeout(netParam.getConnTimeOut())
                //从连接池中获取连接的超时时间，超时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
                .setConnectionRequestTimeout(netParam.getConnReqTimeOut())
                .build();
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }

}
