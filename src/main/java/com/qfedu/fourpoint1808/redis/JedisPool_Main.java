package com.qfedu.fourpoint1808.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *@Author feri
 *@Date Created in 2019/4/25 10:05
 */
public class JedisPool_Main {
    public static void main(String[] args) {
        //1、创建连接池的配置对象 连接池优化
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxIdle(300);//空闲时间
        config.setMaxTotal(1000);//最大连接
        config.setMinIdle(100);
        //2、创建连接池对象
        JedisPool jedisPool=new JedisPool(config,"39.105.189.141",6379,1000,"qfjava");
        //3、获取连接对象
        Jedis jedis=jedisPool.getResource();

        jedis.setex("s2",30,"30秒后消失");
        System.out.println(jedis.get("s2"));
        //4、销毁
        jedis.close();

    }
}
