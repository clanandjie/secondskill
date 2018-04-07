package com.fanzs.secondskill.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by fzs on 2018/4/1.
 */
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    @Autowired
    RedisConfig redisConfig;

    public <T> T get(String key,Class<T> clazz){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String str=jedis.get(key);
            T t=stringToBean(str,clazz);
            return t;
        }finally {
            returnToJedis(jedis);
        }
    }

   /* @Bean
    public JedisPool JedisPoolFactory(){
        JedisPoolConfig poolConfig=new JedisPoolConfig();

        System.out.println(redisConfig);
        System.out.println(poolConfig);
        System.out.println(jedisPool);

        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait()*1000);

        JedisPool jp=new JedisPool(poolConfig,redisConfig.getHost(),
                redisConfig.getPort(),redisConfig.getTimeout()*1000,
                redisConfig.getPassword(),0);
        return jp;
    }*/



    public <T> boolean set(String key,T value){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String str=beanToString(value);
            if(str==null||str.length()<=0){
                System.out.println("set error!");
                return false;
            }
            System.out.println("set error!");

            jedis.set(key,str);
            return true;
        }finally {
            returnToJedis(jedis);
        }
    }

    private <T> String beanToString(T value){
        if(null==value){
            return null;
        }
        Class<?> clazz=value.getClass();
        if(clazz==int.class || clazz==Integer.class){
            return ""+value;
        }else if(clazz==long.class || clazz==Long.class){
            return ""+value;
        }else if(clazz==String.class){
            return (String)value;
        }else{
            return JSON.toJSONString(value);
        }
    }

    private <T> T stringToBean(String str,Class<T> clazz) {
        if(null==str || str.length()<=0 || clazz==null) {
            return null;
        }
        if(clazz==int.class || clazz==Integer.class){
            return (T)Integer.valueOf(str);
        }else if(clazz==long.class || clazz==Long.class){
            return (T)Long.valueOf(str);
        }else if(clazz==String.class){
            return (T)str.toString();
        }else{
            return JSON.toJavaObject(JSON.parseObject(str),clazz);
        }
     }

    private void returnToJedis(Jedis jedis) {
        if(jedis!=null){
            jedis.close();
        }
    }
}
