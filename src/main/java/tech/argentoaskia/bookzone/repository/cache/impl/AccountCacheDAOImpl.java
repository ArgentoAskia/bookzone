package tech.argentoaskia.bookzone.repository.cache.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.redis.account.*;
import tech.argentoaskia.bookzone.repository.cache.account.AccountCacheDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountCacheDAOImpl implements AccountCacheDAO {


    private final JedisPool jedisPool;
    private static final Logger logger = LoggerFactory.getLogger(AccountCacheDAOImpl.class);

    @Autowired
    public AccountCacheDAOImpl(JedisPool jedisPool){
        this.jedisPool = jedisPool;
        logger.info("创建AccountCacheDAO类");
    }

    @Override
    public synchronized void cacheAllAccountEmail(List<AccountEmailListRedis> emailListRedisList) {
        Jedis jedis = jedisPool.getResource();
        // 获取第一个缓存的key，注意AccountEmailListRedis类型key = type
        String key = emailListRedisList.get(0).key();
        logger.info("redis Account Email key：{}", key);
        String[] emailListRedisStrType = new String[emailListRedisList.size()];
        for (int i = 0; i < emailListRedisStrType.length; i++) {
            logger.info("redis Account Email count:{}, value：{}", i, emailListRedisList.get(i).value());
            emailListRedisStrType[i] = emailListRedisList.get(i).value();
        }
        // 添加进缓存
        jedis.sadd(key,emailListRedisStrType);
        jedis.close();
    }

    @Override
    public void cacheAllAccountUIDName(List<AccountUIDNameHashRedis> uidNameHashRedisList) {
        Jedis jedis = jedisPool.getResource();
        Map<String, String> map = new HashMap<>();
        for (AccountUIDNameHashRedis UIDName :
                uidNameHashRedisList) {
            logger.info("redis Account Email UID：{}，Name：{}", UIDName.key(), UIDName.value());
            map.put(UIDName.key(), UIDName.value());
        }
        // !!!
        // jedis.hset("AccountUIDNameHashRedis", map);
        jedis.hmset("AccountUIDNameHashRedis", map);
        jedis.close();
    }

    /**
     * 当删除某个UID用户的时候，会将该可用的UID保存到缓存
     *
     * @param usableUIDSetRedis
     */
    @Override
    public void cacheDeletedUsableUID(AccountUsableUIDSetRedis usableUIDSetRedis) {
        Jedis jedis = jedisPool.getResource();
        jedis.sadd(usableUIDSetRedis.key(),usableUIDSetRedis.value());
        jedis.close();
    }

    @Override
    public AccountUsableUIDSetRedis getUsableUID() {
        return null;
    }

    @Override
    public void cacheUserStatus(List<AccountUserStatusHashRedis> userStatusHashRedis) {
        Jedis jedis = jedisPool.getResource();
        String key = userStatusHashRedis.get(0).type();
        Map<String, String> map = new HashMap<>();
        for (AccountUserStatusHashRedis statusHashRedis :
                userStatusHashRedis) {
            map.put(statusHashRedis.key(), statusHashRedis.value());
        }
        jedis.hset(key, map);
        jedis.close();

    }

    @Override
    public void getUserStatus(AccountUserStatusHashRedis userStatusHashRedis) {

    }

    @Override
    public String getUserStatus(Long uid) {
        return null;
    }

    /**
     * 加载当前在线用户的或者与之关联的用户的热信息，如用户投币给另外一个用户，则另外一个用户就是关联信息。
     * 关联的信息将通过定时器推送到数据库
     * 在线用户热信息通过servlet事件来推送到数据库
     *
     * @param hotMessageHashRedis
     */
    @Override
    public void cacheUserHotMessage(AccountUserHotMessageHashRedis hotMessageHashRedis) {
        Jedis jedis = jedisPool.getResource();
        jedis.hsetnx(hotMessageHashRedis.type(),hotMessageHashRedis.key(), hotMessageHashRedis.value());
        jedis.close();
    }

    @Override
    public void getUserHotMessage(AccountUserHotMessageHashRedis hotMessageHashRedis) {

    }

    @Override
    public void registedAccount(AccountUIDNameHashRedis accountUIDNameHashRedis, AccountEmailListRedis accountEmailListRedis) {
        Jedis jedis = jedisPool.getResource();
        jedis.hset("AccountUIDNameHashRedis", accountUIDNameHashRedis.key(), accountEmailListRedis.value());
        jedis.sadd(accountEmailListRedis.key(), accountEmailListRedis.value());
        jedis.close();
    }

    @Override
    public void removeAccountEmail(AccountUIDNameHashRedis accountUIDNameHashRedis, AccountEmailListRedis accountEmailListRedis) {
        Jedis jedis = jedisPool.getResource();
        jedis.hdel("AccountUIDNameHashRedis", accountUIDNameHashRedis.key());
        jedis.srem(accountEmailListRedis.key(), accountEmailListRedis.value());
        jedis.close();
    }

    @Override
    public String updateAccountUIDName(AccountUIDNameHashRedis oldUIDName, AccountUIDNameHashRedis newUIDName) {
        Jedis jedis = jedisPool.getResource();
        String hget = jedis.hget(oldUIDName.type(), oldUIDName.key());
        jedis.hset(oldUIDName.type(), oldUIDName.key(), newUIDName.value());
        jedis.close();
        return hget;
    }

    @Override
    public void getAccountUID(AccountUIDNameHashRedis accountUIDNameHashRedis) {
        Jedis jedis = jedisPool.getResource();
        String uid = jedis.hget(accountUIDNameHashRedis.type(), accountUIDNameHashRedis.key());
        UID uid1 = new UID(Long.parseLong(uid));
        accountUIDNameHashRedis.setUid(uid1);
        jedis.close();
    }

    @Override
    public UID getAccountUID(String userName) {
        Jedis jedis = jedisPool.getResource();
        String uid = jedis.hget("AccountUIDNameHashRedis", userName);
        UID uid1 = new UID(Long.parseLong(uid));
        jedis.close();
        return uid1;
    }

    @Override
    public boolean checkUserNameExist(AccountUIDNameHashRedis accountUIDNameHashRedis) {
        Jedis jedis = jedisPool.getResource();
        Boolean hexists = jedis.hexists(accountUIDNameHashRedis.type(), accountUIDNameHashRedis.key());
        jedis.close();
        return hexists;
    }

    @Override
    public boolean checkUserNameExist(String userName) {
        AccountUIDNameHashRedis accountUIDNameHashRedis = new AccountUIDNameHashRedis();
        accountUIDNameHashRedis.setName(userName);
        return checkUserNameExist(accountUIDNameHashRedis);
    }

    /**
     * 检查email是否存在，用于注册
     *
     * @param email
     * @return
     */
    @Override
    public boolean checkEmailExist(AccountEmailListRedis email) {
        Jedis jedis = jedisPool.getResource();
        Boolean sismember = jedis.sismember(email.key(), email.value());
        jedis.close();
        return sismember;
    }

    @Override
    public boolean checkEmailExist(String email) {
        AccountEmailListRedis accountEmailListRedis = new AccountEmailListRedis();
        accountEmailListRedis.setEmailsList(email);
        return checkEmailExist(accountEmailListRedis);
    }
}
