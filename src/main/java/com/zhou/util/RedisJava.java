package com.zhou.util;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class RedisJava {
    @Autowired
    private JedisPool jedisPool;
    public static void main(String[] args) {

    }

    public void test(){
        jedisPool.getResource();
//        Jedis jedis =new Jedis("localhost");
//        // jedis.auth("123456");
//
//        jedis.lpush("site-list", "Runoob");
//        jedis.lpush("site-list", "Google");
//        jedis.lpush("site-list", "Taobao");
//        List<String> list = jedis.lrange("site-list", 0 ,2);
//        System.out.println(list.toString());
    }


}
