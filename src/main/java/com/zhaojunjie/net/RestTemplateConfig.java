package com.zhaojunjie.net;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class RestTemplateConfig {

    private ApplicationValues appValues = new ApplicationValues();

    public RestTemplate restTemplate() {
        return new RestTemplate(httpRequestFactory());
    }

    public ClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }

    public HttpClient httpClient() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(appValues.getMaxTotal());
        connectionManager.setDefaultMaxPerRoute(appValues.getMaxPerRoute());
        connectionManager.setValidateAfterInactivity(appValues.getInactivity());
        RequestConfig requestConfig = RequestConfig.custom()
                //?????????????????????(response)????????????????????????read timeout
                .setSocketTimeout(appValues.getSocketTimeout())
                //??????????????????(????????????)????????????????????????connect timeout
                .setConnectTimeout(appValues.getConnTimeOut())
                //???????????????????????????????????????????????????????????????????????????????????????org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
                .setConnectionRequestTimeout(appValues.getConnReqTimeOut())
                .build();
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }
}
