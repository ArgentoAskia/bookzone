package tech.argentoaskia.bookzone.controller.servlet.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.argentoaskia.bookzone.controller.servlet.BaseController;
import tech.argentoaskia.bookzone.model.beans.visual.AccountUserMessage;

import javax.imageio.ImageIO;
import java.io.IOException;

@Controller
@RequestMapping("/icon")
public class IconResourceController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(IconResourceController.class);
    @RequestMapping("/profile")
    public void getProfileIcon(){
        AccountUserMessage accountUserMessage = (AccountUserMessage) session.getAttribute("accountUserMessage");
        logger.info("accountUserMessage:{}", accountUserMessage);
        logger.info("accountUserMessageIcon:{}", accountUserMessage.getIcon().get());
        if(accountUserMessage != null){
            try {
                ImageIO.write(accountUserMessage.getIcon().get(), "jpg", response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
