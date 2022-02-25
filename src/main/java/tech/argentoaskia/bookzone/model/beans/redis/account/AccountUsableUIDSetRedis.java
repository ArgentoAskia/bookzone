package tech.argentoaskia.bookzone.model.beans.redis.account;

import redis.clients.jedis.Jedis;
import tech.argentoaskia.bookzone.model.beans.redis.RedisKeyValueModel;

public class AccountUsableUIDSetRedis implements RedisKeyValueModel {

    private Long uid;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public String key() {
        return "AccountUsableUIDSetRedis";
    }

    @Override
    public String value() {
        return String.valueOf(uid);
    }
}
