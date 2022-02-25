package tech.argentoaskia.bookzone.controller.servlet.account;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import tech.argentoaskia.bookzone.controller.servlet.BaseController;
import tech.argentoaskia.bookzone.exception.InvalidUserPwdException;
import tech.argentoaskia.bookzone.exception.UserNotFoundException;
import tech.argentoaskia.bookzone.model.beans.visual.AccountSecurityMessage;
import tech.argentoaskia.bookzone.model.beans.visual.AccountUserMessage;
import tech.argentoaskia.bookzone.service.account.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册登录等页面
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    // ajax
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(String user, String password, Boolean rememberPwd, Integer tryCount){
        logger.info("登录请求完毕");
        logger.info("用户名：" + user);
        logger.info("密码Hash：" + password);
        logger.info("是否记住密码：" + rememberPwd);
        logger.info("尝试登陆次数：" + tryCount);
        AccountUserMessage accountUserMessage;
        try {
            accountUserMessage = accountService.checkAccount(user, password);
            if(rememberPwd){
                logger.info("正在记住账号密码");
                Cookie user1 = new Cookie("user", user);
                Cookie pwd = new Cookie("pwd", password);
                user1.setMaxAge(15768000);
                pwd.setMaxAge(15768000);
                response.addCookie(user1);
                response.addCookie(pwd);
            }

            // TODO: 2022/2/15 跳转到个人主页
            session.setAttribute("accountUserMessage", accountUserMessage);
            logger.info("登陆成功之后设置个人信息:{}", accountUserMessage);
            Long uid = accountUserMessage.getUid().get();
            String redirect = "user" + "/profile/" + uid;
            logger.info("重定向:{}", redirect);
            response.setHeader("redirect", redirect);
            /*
                上面的代码不序列化AccountUserMessage实体类，将会抛SerializationException。
                原因在于Spring会把session对象序列化到redis中，序列化session时，会把session的
                所有attribute序列化，当无法序列化上面的代码不序列化AccountUserMessage实体类，
                因此会报错。具体细节参考：org.springframework.session.data.redis.RedisIndexedSessionRepository类源代码
                通过这个类可以实现在线t人的方法：https://zhuanlan.zhihu.com/p/362961697
                建议所有的实体类都进行序列化！！
             */
            /*
             另外Ajax中不支持重定向，可以使用这样的技巧
             */
        } catch (InvalidUserPwdException e) {
            // TODO: 2022/2/15 跳转到账号密码错误对话框
            try {
                int tryCounts = tryCount;
                if ((++tryCounts) >= 3) {
                    response.getWriter().println("您已连续" + tryCounts + "次密码错误，如果您忘记密码，您可以点击<a href=\"registe.html\" style=\"color: dodgerblue;font-weight:bold\">此处</a>来找回密码&" + tryCounts);
                } else {
                    response.getWriter().println("密码错误！请输入正确密码！&"+ tryCounts);
                }
            }catch(IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (UserNotFoundException e){
            // TODO: 2022/2/15 提示账号不存在，是否需要注册
            try {
                response.getWriter().println("该用户不存在，您可以点击<a href=\"registe.html\" style=\"color: dodgerblue;font-weight:bold\">这里</a>进行注册");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    @RequestMapping(value = "/registed", method = RequestMethod.POST)
    public String registe(String uname, String uemail, String upassword,
                        String question1, String answer1,
                        String question2, String answer2,
                        String question3, String answer3){
        AccountSecurityMessage message = new AccountSecurityMessage();
        message.setAnswer1(answer1);
        message.setAnswer2(answer2);
        message.setAnswer3(answer3);
        message.setQuestion1(question1);
        message.setQuestion2(question2);
        message.setQuestion3(question3);
        message.setUemail(uemail);
        message.setUname(uname);
        message.setUpassword(upassword);
        accountService.registeAccount(message);
        // TODO: 2022/2/16 跳转到login.html
        return null;
    }

    @RequestMapping("/text")
    public String forgetPwd() {
        return null;
    }



    // ajax controller
    @RequestMapping(value = "/unique/email/{email}", method = RequestMethod.GET)
    public void checkEmailUnique(@PathVariable("email") String email){
    }
    @RequestMapping(value = "/unique/name/{name}", method = RequestMethod.GET)
    public void checkNameUnique(@PathVariable("name") String name){

    }
}
