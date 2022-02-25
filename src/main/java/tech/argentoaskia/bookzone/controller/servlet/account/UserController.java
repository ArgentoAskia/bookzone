package tech.argentoaskia.bookzone.controller.servlet.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tech.argentoaskia.bookzone.controller.servlet.BaseController;
import tech.argentoaskia.bookzone.model.beans.visual.AccountUserMessage;
import tech.argentoaskia.bookzone.service.account.AccountService;

import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    private AccountService accountService;

    @Autowired
    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 用户主页
     * @return
     */
    @RequestMapping(value = "profile/{uid}",method = RequestMethod.GET)
    public String userProfile(@PathVariable("uid") Long uid, ModelMap map){
        AccountUserMessage accountUserMessage = (AccountUserMessage) session.getAttribute("accountUserMessage");
        if(accountUserMessage == null){
            try {
                response.sendRedirect("login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.debug("URl{}", accountUserMessage);
        map.addAttribute("accountUserMessageIcon", "/icon/profile");
        return "userMessageProfileTemplate";
    }

    // ajax
    public String userFrame(){
        return null;
    }
    public String bookManageFrame(){
        return null;
    }
    public String readingRecordFrame(){
        return null;
    }
    public String collectionsFrame(){
        return null;
    }
    public String privateMessageFrame(){
        return null;
    }
    public String expRecordFrame(){
        return null;
    }
}
