package tech.argentoaskia.bookzone.service.account.impl;

import io.netty.util.internal.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.argentoaskia.bookzone.exception.InvalidIDTypeException;
import tech.argentoaskia.bookzone.exception.InvalidUserPwdException;
import tech.argentoaskia.bookzone.exception.UserNotFoundException;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.original.AccountMessage;
import tech.argentoaskia.bookzone.model.beans.original.UserMessage;
import tech.argentoaskia.bookzone.model.beans.visual.AccountSecurityMessage;
import tech.argentoaskia.bookzone.model.beans.visual.AccountUserMessage;
import tech.argentoaskia.bookzone.model.factory.visual.account.AccountVisualMessageFactory;
import tech.argentoaskia.bookzone.repository.cache.account.AccountCacheDAO;
import tech.argentoaskia.bookzone.repository.mapper.account.AccountCollectionsDAO;
import tech.argentoaskia.bookzone.repository.mapper.account.AccountMessageDAO;
import tech.argentoaskia.bookzone.repository.mapper.account.AccountPrivateMessageDAO;
import tech.argentoaskia.bookzone.repository.mapper.account.UserMessageDAO;
import tech.argentoaskia.bookzone.service.account.AccountService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountVisualMessageFactory accountVisualMessageFactory;
    private AccountCacheDAO cacheDAO;
    private AccountMessageDAO messageDAO;
    private UserMessageDAO userMessageDAO;
    private AccountCollectionsDAO collectionsDAO;
    private AccountPrivateMessageDAO privateMessageDAO;
    public AccountServiceImpl(){}

    @Autowired
    public void setCollectionsDAO(AccountCollectionsDAO collectionsDAO) {
        this.collectionsDAO = collectionsDAO;
    }

    @Autowired
    public void setPrivateMessageDAO(AccountPrivateMessageDAO privateMessageDAO) {
        this.privateMessageDAO = privateMessageDAO;
    }

    @Autowired
    public void setAccountVisualMessageFactory(AccountVisualMessageFactory accountVisualMessageFactory) {
        this.accountVisualMessageFactory = accountVisualMessageFactory;
    }

    @Autowired
    public void setUserMessageDAO(UserMessageDAO userMessageDAO) {
        this.userMessageDAO = userMessageDAO;
    }

    @Autowired
    public void setCacheDAO(AccountCacheDAO cacheDAO) {
        this.cacheDAO = cacheDAO;
    }

    @Autowired
    public void setMessageDAO(AccountMessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public AccountUserMessage checkAccount(String user, String password) throws InvalidUserPwdException, UserNotFoundException {
        AccountUserMessage accountUserMessage = null;
        Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
        if(pattern.matcher(user).matches()){
            accountUserMessage = checkForEmail(user, password);
        }else if(user.length() == 10 && user.startsWith("100")){
            accountUserMessage = checkForUID(new UID(Long.parseLong(user)), password);
        }
        if(accountUserMessage == null){
            accountUserMessage = checkForName(user, password);
        }
        if(accountUserMessage == null){
            throw new UserNotFoundException();
        }
        return accountUserMessage;
    }
    private AccountUserMessage checkForEmail(String email, String pwd) throws InvalidUserPwdException {
        String realPwd = messageDAO.checkAccountByEmail(email);
        if (realPwd == null){
            return null;
        }
        if(realPwd.equals(pwd)){
            // create AccountUserMessage
            AccountMessage m = new AccountMessage();
            m.setEmail(email);
            List<AccountMessage> accountMessages = messageDAO.selectByOriginalType(m);

            AccountMessage message = accountMessages.get(0);
            UserMessage userMessage = userMessageDAO.selectByUID(message.getUid().getId());
            int var1 = privateMessageDAO.selectUnReadMessageCount(message.getUid());
            int var2 = collectionsDAO.getCollectionsUpdate(message.getUid());
            return accountVisualMessageFactory.ToAccountUserMessage(message,userMessage,var2,var1);
        }else{
            throw new InvalidUserPwdException();
        }
    }
    private AccountUserMessage checkForUID(UID uid, String pwd) throws InvalidUserPwdException {
        String realPwd = messageDAO.checkAccountByUID(uid.getId());
        if (realPwd == null){
            return null;
        }
        if(realPwd.equals(pwd)){
            // create AccountUserMessage
            AccountMessage message = messageDAO.selectByUID(uid);
            UserMessage userMessage = userMessageDAO.selectByUID(uid.getId());
            int var1 = privateMessageDAO.selectUnReadMessageCount(uid);
            int var2 = collectionsDAO.getCollectionsUpdate(uid);
            return accountVisualMessageFactory.ToAccountUserMessage(message,userMessage,var2,var1);
        }else{
            throw new InvalidUserPwdException();
        }

    }
    private AccountUserMessage checkForName(String name, String pwd) throws InvalidUserPwdException {
        String realPwd = messageDAO.checkAccountByName(name);
        if (realPwd == null){
            return null;
        }
        if(realPwd.equals(pwd)){
            // create AccountUserMessage
            UID accountUID = cacheDAO.getAccountUID(name);
            AccountMessage message = messageDAO.selectByUID(accountUID);
            UserMessage userMessage = userMessageDAO.selectByUID(accountUID.getId());
            int var1 = privateMessageDAO.selectUnReadMessageCount(accountUID);
            int var2 = collectionsDAO.getCollectionsUpdate(accountUID);
            return accountVisualMessageFactory.ToAccountUserMessage(message,userMessage,var2,var1);
        }else{
            throw new InvalidUserPwdException();
        }

    }

    /**
     * 负责注册用户基本信息并加载进相关键值对到内存！
     *
     * @param securityMessage
     */
    @Override
    public void registeAccount(AccountSecurityMessage securityMessage) {

    }

    @Override
    public boolean checkEmailUnique(String email) {
        return false;
    }

    @Override
    public boolean checkNameUnique(String name) {
        return false;
    }
}
