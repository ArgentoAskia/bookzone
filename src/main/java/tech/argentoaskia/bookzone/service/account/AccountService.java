package tech.argentoaskia.bookzone.service.account;


import tech.argentoaskia.bookzone.exception.InvalidUserPwdException;
import tech.argentoaskia.bookzone.exception.UserNotFoundException;
import tech.argentoaskia.bookzone.model.beans.visual.AccountSecurityMessage;
import tech.argentoaskia.bookzone.model.beans.visual.AccountUserMessage;

public interface AccountService {

    /**
     * 登录用户，并获取相关个人信息，最后加工成可视化的个人主页信息
     * @param user
     * @param password
     * @return
     * @throws InvalidUserPwdException
     */
    AccountUserMessage checkAccount(String user, String password) throws InvalidUserPwdException, UserNotFoundException;
    /**
     * 负责注册用户基本信息并加载进相关键值对到内存！
     * @param securityMessage
     */
    void registeAccount(AccountSecurityMessage securityMessage);

    boolean checkEmailUnique(String email);
    boolean checkNameUnique(String name);

}
