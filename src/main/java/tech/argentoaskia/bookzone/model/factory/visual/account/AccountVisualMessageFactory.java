package tech.argentoaskia.bookzone.model.factory.visual.account;

import org.springframework.stereotype.Service;
import tech.argentoaskia.bookzone.model.beans.original.AccountMessage;
import tech.argentoaskia.bookzone.model.beans.original.UserMessage;
import tech.argentoaskia.bookzone.model.beans.visual.AccountUserMessage;

@Service
public class AccountVisualMessageFactory {

    public AccountUserMessage ToAccountUserMessage(AccountMessage accountMessage, UserMessage message,int collectionUpdates, int privateMessages){
        AccountUserMessage accountUserMessage = new AccountUserMessage();
        accountUserMessage.setAbleCom(message.getAbleCom());
        accountUserMessage.setAge(message.getAge());
        accountUserMessage.setCoins(message.getCoins());
        accountUserMessage.setEmail(accountMessage.getEmail());
        accountUserMessage.setExp(message.getExp());
        accountUserMessage.setIcon(message.getIcon());
        accountUserMessage.setIntroduction(message.getIntroduction());
        accountUserMessage.setLv(message.getLv());
        accountUserMessage.setName(accountMessage.getName());
        accountUserMessage.setRegistedTime(message.getRegistedTime());
        accountUserMessage.setUid(accountMessage.getUid());
        accountUserMessage.setCountForCollectionsUpdate(collectionUpdates);
        accountUserMessage.setCountForPrivateMessage(privateMessages);
        return accountUserMessage;
    }

}
