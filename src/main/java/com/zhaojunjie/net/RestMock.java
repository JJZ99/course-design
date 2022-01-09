package com.zhaojunjie.net;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/youbitch1/article/details/106117173
 */
public class RestMock{

    private RestTemplateConfig restTemplateConfig = new RestTemplateConfig();



    private RestTemplate restTemplate = restTemplateConfig.restTemplate();

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
        if (params != null && params.size() > 0) {
            sb.append("?");
            for (Map.Entry map : params.entrySet()) {
                sb.append(map.getKey())
                        .append("=")
                        .append(map.getValue())
                        .append("&");
            }
            uri = sb.substring(0, sb.length() - 1);
            System.out.println(uri);
            return uri;
        }
        System.out.println(sb.toString());

        return sb.toString();
    }
    public String sendGet(String protocol, String uri, Map<String, String> params) {


        ResponseEntity responseEntity = restTemplate.getForEntity
                (
                        generateRequestParameters(protocol, uri, params),
                        String.class
                );
        return (String) responseEntity.getBody();
    }

}