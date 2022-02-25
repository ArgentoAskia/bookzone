package tech.argentoaskia.bookzone.model.beans.redis.account;

import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.redis.RedisKeyValueModel;
import tech.argentoaskia.bookzone.utils.JSONUtil;

public class AccountUserHotMessageHashRedis implements RedisKeyValueModel {
    private UID uid;

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    private Integer lv;
    private Integer exp;
    private Integer coins;

    public Integer getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = lv;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    @Override
    public String key() {
        return String.valueOf(uid.getId());
    }

    @Override
    public String value() {
        return JSONUtil.bean2Json(this);
    }

    @Override
    public String toString() {
        return "AccountUserHotMessage{" +
                "uid=" + uid +
                ", lv=" + lv +
                ", exp=" + exp +
                ", coins=" + coins +
                '}';
    }
}
