package com.qfedu.fourpoint1808.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/4/25 09:49
 */
public class Jedis_Main {
    public static void main(String[] args) {
        //1、创建Jedis对象
        Jedis jedis=new Jedis("39.105.189.141",6379);
        //2、密码认证
        jedis.auth("qfjava");
        //3、操作Redis
        jedis.flushAll();
        //String
        jedis.set("s1","Hello,Jedis");
        System.out.println(jedis.get("s1"));
        jedis.expire("s1",100);
        //List
        jedis.lpush("list1",new String[]{"a","b","c"});
        System.out.println(jedis.lrange("list1",0,jedis.llen("list1")-1));
        //Set
        jedis.sadd("set1","ac","bc");
        System.out.println(jedis.smembers("set1"));
        //ZSet
        jedis.zadd("zset1",3.4,"张三");
        jedis.zadd("zset1",3.4,"李四");
        Map<String,Double> map=new HashMap<>();
        map.put("www",22.0);
        map.put("qqq",33.0);
        jedis.zadd("zset1",map);
        System.out.println(jedis.zrange("zset1",0,jedis.zcard("zset1")-1));
        //Hash
        jedis.hset("hash1","token:1001","name:admin");
        Map<String,String> map1=new HashMap<>();
        map1.put("token:1002","name:user");
        jedis.hset("hash1",map1);
        System.out.println(jedis.hgetAll("hash1"));
        //系统命令
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.randomKey());

    }
}
