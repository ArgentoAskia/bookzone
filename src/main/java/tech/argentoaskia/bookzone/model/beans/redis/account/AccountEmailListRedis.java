package tech.argentoaskia.bookzone.model.beans.redis.account;

import redis.clients.jedis.Jedis;
import tech.argentoaskia.bookzone.model.beans.redis.RedisKeyValueModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AccountEmailListRedis implements RedisKeyValueModel {

    private String email;


    public String getEmailsList() {
        return email;
    }

    public void setEmailsList(String email) {
        this.email = email;
    }

    @Override
    public String key() {
        return "AccountEmailListRedis";
    }

    @Override
    public String value() {
        return email;
    }

}
