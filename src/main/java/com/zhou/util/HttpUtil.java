package com.zhou.util;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtil {
    public static void read(){
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet("https://www.biquge5200.cc/52_52542/");
            CloseableHttpResponse response = httpClient.execute(get);
            System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));
            httpClient.close();
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HttpUtil.read();
    }
}
