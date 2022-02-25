package tech.argentoaskia.bookzone.controller.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 这些对象何以直接被子类使用
@Controller
public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest req, HttpServletResponse res) {
        this.request = req;
        this.response = res;
        this.session = req.getSession();
    }
    @RequestMapping("/close")
    public void close(){
        System.out.println("清空存储");
        session.removeAttribute("InvalidUserPwdExceptionThrowCount");
    }
}