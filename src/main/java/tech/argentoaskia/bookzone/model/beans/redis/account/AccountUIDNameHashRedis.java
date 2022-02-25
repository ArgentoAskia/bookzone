package tech.argentoaskia.bookzone.model.beans.redis.account;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import redis.clients.jedis.Jedis;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.redis.RedisKeyValueModel;

public class AccountUIDNameHashRedis implements RedisKeyValueModel {
    private UID uid;
    private String name;

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AccountUIDNameHashRedis{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                '}';
    }

    public String key(){
        return name;
    }

    @Override
    public String value() {
        return String.valueOf(uid.get());
    }
}
