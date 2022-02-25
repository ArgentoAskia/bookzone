package tech.argentoaskia.bookzone.model.factory.redis.account;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.original.AccountMessage;
import tech.argentoaskia.bookzone.model.beans.redis.account.AccountEmailListRedis;
import tech.argentoaskia.bookzone.model.beans.redis.account.AccountUIDNameHashRedis;

import java.util.List;

@Service
public class AccountRedisCacheDataFactory {


    public void AccountMessageToMemoryCache(List<AccountMessage> messages,
                                            List<AccountEmailListRedis> accountEmailListRedisList,
                                            List<AccountUIDNameHashRedis> accountUIDNameHashRedisList){
        if(accountEmailListRedisList == null)
            throw new RuntimeException();
        if(accountUIDNameHashRedisList == null){
            throw new RuntimeException();
        }
        AccountEmailListRedis emailListRedis;
        AccountUIDNameHashRedis uidNameHashRedis;
        for (AccountMessage message:
             messages) {
            emailListRedis = new AccountEmailListRedis();
            uidNameHashRedis = new AccountUIDNameHashRedis();
            DivideAccountMessageToRedisCache(message,emailListRedis,uidNameHashRedis);
            accountEmailListRedisList.add(emailListRedis);
            accountUIDNameHashRedisList.add(uidNameHashRedis);
        }
    }

    public void DivideAccountMessageToRedisCache(AccountMessage message, AccountEmailListRedis accountEmailListRedis, AccountUIDNameHashRedis uidNameHashRedis){
        uidNameHashRedis.setUid(message.getUid());
        uidNameHashRedis.setName(message.getName());
        accountEmailListRedis.setEmailsList(message.getEmail());
    }
}
