package com.metadata.utils.test;

import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2016/8/21.
 */
public class JedisDemo {
    public static void main(String[] args) {
        // 构造jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 向redis中添加数据
        jedis.set("mytest", "123");
        // 从redis中读取数据
        String value = jedis.get("mytest");

        System.out.println(value);
        // 关闭连接
        jedis.close();
    }

}

