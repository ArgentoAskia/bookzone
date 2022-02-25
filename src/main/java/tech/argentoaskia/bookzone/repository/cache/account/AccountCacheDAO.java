package tech.argentoaskia.bookzone.repository.cache.account;

import tech.argentoaskia.bookzone.model.beans.atomic.BookManageStatus;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.redis.account.*;
import tech.argentoaskia.bookzone.repository.cache.CacheDAO;

import java.util.List;

public interface AccountCacheDAO extends CacheDAO {

    /**
     * 初始化时候缓存所有已经注册的email
     * @param emailListRedisList
     */
    void cacheAllAccountEmail(List<AccountEmailListRedis> emailListRedisList);

    /**
     * 初始化时候缓存所有已经注册的用户名
     * @param uidNameHashRedisList
     */
    void cacheAllAccountUIDName(List<AccountUIDNameHashRedis> uidNameHashRedisList);

    /**
     * 加载当前在线用户的或者与之关联的用户的热信息，如用户投币给另外一个用户，则另外一个用户就是关联信息。
     * 关联的信息将通过定时器推送到数据库
     * 在线用户热信息通过servlet事件来推送到数据库
     */
    void cacheUserHotMessage(AccountUserHotMessageHashRedis hotMessageHashRedis);

    void getUserHotMessage(AccountUserHotMessageHashRedis hotMessageHashRedis);

    /**
     * 当注册成功的时候会把新用户添加到缓存
     * @param accountUIDNameHashRedis
     * @param accountEmailListRedis
     */
    void registedAccount(AccountUIDNameHashRedis accountUIDNameHashRedis, AccountEmailListRedis accountEmailListRedis);

    /**
     * 删除用户的时候同时删除相关缓存信息
     * @param accountUIDNameHashRedis
     * @param accountEmailListRedis
     */
    void removeAccountEmail(AccountUIDNameHashRedis accountUIDNameHashRedis, AccountEmailListRedis accountEmailListRedis);

    /**
     * 当用户更新用户名的时候触发更新缓存
     * @param oldUIDName
     * @param newUIDName
     * @return
     */
    String updateAccountUIDName(AccountUIDNameHashRedis oldUIDName, AccountUIDNameHashRedis newUIDName);

    /**
     * 获取用户UID
     * @param accountUIDNameHashRedis
     */
    void getAccountUID(AccountUIDNameHashRedis accountUIDNameHashRedis);
    UID getAccountUID(String userName);

    /**
     * 检查用户名是否存在，用于注册
     * @param accountUIDNameHashRedis
     * @return
     */
    boolean checkUserNameExist(AccountUIDNameHashRedis accountUIDNameHashRedis);
    boolean checkUserNameExist(String userName);

    /**
     * 检查email是否存在，用于注册
     * @param email
     * @return
     */
    boolean checkEmailExist(AccountEmailListRedis email);
    boolean checkEmailExist(String email);


    /**
     * 当删除某个UID用户的时候，会将该可用的UID保存到缓存,用于注册
     * @param usableUIDSetRedis
     */
    void cacheDeletedUsableUID(AccountUsableUIDSetRedis usableUIDSetRedis);
    AccountUsableUIDSetRedis getUsableUID();

    void cacheUserStatus(List<AccountUserStatusHashRedis> userStatusHashRedis);

    /**
     * 查看用户状态，用于登陆时
     * @param userStatusHashRedis
     */
    void getUserStatus(AccountUserStatusHashRedis userStatusHashRedis);
    String getUserStatus(Long uid);

}
