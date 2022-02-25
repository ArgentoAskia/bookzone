package tech.argentoaskia.bookzone.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
@Deprecated
public class JedisUtil {

    @Autowired
    private JedisPool jedisPool;


    // key 操作
    public Long del(String key){
        Jedis jedis = jedisPool.getResource();
        Long l = jedis.del(key);
        jedis.close();
        return l;
    }

    public boolean exists(String key){
        Jedis jedis = jedisPool.getResource();
        Boolean b = jedis.exists(key);
        jedis.close();
        return b;
    }

    public void expire(String key, long seconds){
        Jedis jedis = jedisPool.getResource();
        jedis.expire(key, seconds);
        jedis.close();
    }



    // string  操作
    public void set(String key, String value){
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
        jedis.close();
    }

}
