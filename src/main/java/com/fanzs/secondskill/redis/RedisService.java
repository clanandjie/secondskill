package com.fanzs.secondskill.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by fzs on 2018/4/1.
 */
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * 获取单个对象
     * @param prefix
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String realKey=prefix.getPrefix()+key;
            String str=jedis.get(realKey);
            T t=stringToBean(realKey,clazz);
            return t;
        }finally {
            returnToJedis(jedis);
        }
    }

    /**
     * 设置对象
     * @param prefix
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String str=beanToString(value);
            if(str==null||str.length()<=0){
//                System.out.println("set error!");
                return false;
            }
            String realKey=prefix.getPrefix()+key;
            int seconds=prefix.expireSeconds();
            if(seconds<0){
                jedis.set(realKey,str);
            }else{
                jedis.setex(realKey,seconds,str);
            }
            return true;
        }finally {
            returnToJedis(jedis);
        }
    }

    /**
     * 判断是否存在
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean exists(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String realKey=prefix.getPrefix()+key;
            return jedis.exists(realKey);
        }finally {
            returnToJedis(jedis);
        }
    }

    public <T> Long incr(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try{
            jedis=jedisPool.getResource();
            String realKey=prefix.getPrefix()+key;
            return jedis.incr(realKey);
        }finally {
            returnToJedis(jedis);
        }
    }

    /**
     * 减少单个值
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long decr(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try{
            jedis=jedisPool.getResource();
            String realKey=prefix.getPrefix()+key;
            return jedis.decr(realKey);
        }finally {
            returnToJedis(jedis);
        }
    }

    /**
     * 对象转化为字符串
     * @param value
     * @param <T>
     * @return
     */
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

    /**
     * 字符串转换为bean 对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
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

    /**
     * 归还jedis 到资源池
     * @param jedis
     */
    private void returnToJedis(Jedis jedis) {
        if(jedis!=null){
            jedis.close();
        }
    }
}
