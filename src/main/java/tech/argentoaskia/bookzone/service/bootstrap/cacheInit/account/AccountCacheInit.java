package tech.argentoaskia.bookzone.service.bootstrap.cacheInit.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.argentoaskia.bookzone.model.beans.original.AccountMessage;
import tech.argentoaskia.bookzone.model.beans.redis.account.AccountEmailListRedis;
import tech.argentoaskia.bookzone.model.beans.redis.account.AccountUIDNameHashRedis;
import tech.argentoaskia.bookzone.model.factory.redis.account.AccountRedisCacheDataFactory;
import tech.argentoaskia.bookzone.repository.cache.account.AccountCacheDAO;
import tech.argentoaskia.bookzone.repository.mapper.account.AccountMessageDAO;
import tech.argentoaskia.bookzone.service.bootstrap.CacheInit;

import java.util.LinkedList;
import java.util.List;

/**
 * redis初始化Account缓存信息类
 */
@Service
public class AccountCacheInit implements CacheInit<AccountMessageDAO, AccountCacheDAO> {

    private final static Logger logger = LoggerFactory.getLogger(AccountCacheInit.class);

    private final AccountRedisCacheDataFactory factory;
    private final AccountCacheDAO cacheDAO;
    private final AccountMessageDAO messageDAO;

    @Autowired
    public AccountCacheInit(AccountRedisCacheDataFactory factory, AccountCacheDAO cacheDAO, AccountMessageDAO messageDAO){
        this.factory = factory;
        this.cacheDAO = cacheDAO;
        this.messageDAO = messageDAO;
    }

    @Override
    public boolean init(AccountMessageDAO dbDAO, AccountCacheDAO cacheDAO, int i) {
        System.out.println(dbDAO);
        System.out.println(cacheDAO);
        logger.info("DataBase Type：{}", dbDAO.getClass().getSimpleName());
        logger.info("RedisCache Type：{}", cacheDAO.getClass().getSimpleName());
        List<AccountMessage> accountMessages = dbDAO.selectAll();
        if(accountMessages.size() == 0){
            logger.warn("没有Account在数据库!!");
            return false;
        }
        List<AccountEmailListRedis> emailListRedisList = new LinkedList<>();
        List<AccountUIDNameHashRedis> uidNameHashRedisList = new LinkedList<>();
        factory.AccountMessageToMemoryCache(accountMessages, emailListRedisList, uidNameHashRedisList);
        cacheDAO.cacheAllAccountEmail(emailListRedisList);
        cacheDAO.cacheAllAccountUIDName(uidNameHashRedisList);
        // TODO: 2022/2/22 cache status
        return true;
    }

    @Override
    public AccountMessageDAO getDatabaseDAO() {
        return messageDAO;
    }

    @Override
    public AccountCacheDAO getCacheDAO() {
        return cacheDAO;
    }

    @Override
    public Double order() {
        return 1.0;
    }

}
