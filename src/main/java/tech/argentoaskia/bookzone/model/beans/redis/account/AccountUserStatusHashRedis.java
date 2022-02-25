package tech.argentoaskia.bookzone.model.beans.redis.account;

import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.redis.RedisKeyValueModel;

public class AccountUserStatusHashRedis implements RedisKeyValueModel {
    private UID uid;
    private String status;

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String key() {
        return String.valueOf(uid.getId());
    }

    @Override
    public String value() {
        return status;
    }
}
