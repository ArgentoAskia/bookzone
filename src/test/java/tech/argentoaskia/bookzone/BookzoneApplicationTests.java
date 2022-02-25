package tech.argentoaskia.bookzone;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.BookManageStatus;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.original.AccountBookManage;
import tech.argentoaskia.bookzone.model.beans.original.AccountMessage;
import tech.argentoaskia.bookzone.repository.mapper.account.*;
import tech.argentoaskia.bookzone.service.bootstrap.CacheChain;
import tech.argentoaskia.bookzone.service.bootstrap.CacheInit;
import tech.argentoaskia.bookzone.service.bootstrap.cacheInit.account.AccountCacheInit;
import tech.argentoaskia.bookzone.service.bootstrap.impls.CacheInitChainImpl;
import tech.argentoaskia.bookzone.utils.MsgDigestUtil;
import tech.argentoaskia.bookzone.utils.SpringUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


@SpringBootTest
@ServletComponentScan
public class BookzoneApplicationTests {

    @Autowired
    private AccountMessageDAO accountMessageDAO;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void contextLoads() {
        String path = "D:/OpenSourceProject/bookzone/target/classes/static/img/icon/default_icon.jpg";
        File file = new File(path);
        try {
            Image image = ImageIO.read(file);
            System.out.println(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAccountMapper(){
        String pwd = MsgDigestUtil.digest("sujiewei".getBytes(), MsgDigestUtil.MsgDigestAlgorithm.MD5, MsgDigestUtil.stringType);
        accountMessageDAO.register(false, "RedBuff3", "RedBuff3@outlook.com", pwd);
        logger.info("插入一条记录" + accountMessageDAO.returnInsertUID());
    }


    // TODO: 2022/2/14 test for autowire
    @Test
    void testAutowire2(@Autowired CacheInitChainImpl chain) throws IOException, ClassNotFoundException {
        System.out.println(AccountCacheInit.class.getName());

        Assert.notNull(SpringUtil.getApplicationContext().getBean(CacheInit.class));
    }


    @Autowired
    private AccountBookManageDAO bookManageDAO;
    @Autowired
    private AccountCollectionsDAO collectionsDAO;
    @Autowired
    private AccountEXPRecordDAO expRecordDAO;
    @Autowired
    private AccountMessageDAO messageDAO;
    @Autowired
    private AccountPrivateMessageDAO privateMessageDAO;
    @Autowired
    private AccountReadingRecordDAO readingRecordDAO;
    @Autowired
    private AccountSecurityDAO securityDAO;

    @Test
    void testbookManageDAOInsert(){
        AccountBookManage accountBookManage1 = new AccountBookManage();
        AccountBookManage accountBookManage2 = new AccountBookManage();
        accountBookManage1.setBid(new BID(10000001L));
        accountBookManage1.setBookName("繁星春水");
        accountBookManage1.setUid(new UID(2L));
        accountBookManage1.setStatus(BookManageStatus.online);

        accountBookManage2.setBid(new BID(10000001L));
        accountBookManage2.setBookName("繁星春水");
        accountBookManage2.setUid(new UID(4L));
        accountBookManage2.setStatus(BookManageStatus.online);
        System.out.println(bookManageDAO.insertMore(accountBookManage1, accountBookManage2));
    }

    @Test
    void testBookManageDAOSelect(){
        // List<AccountBookManage> list = bookManageDAO.selectByBID(new BID(1L));
//        System.out.println(list);
//        List<AccountBookManage> list1 = bookManageDAO.selectByUID(new UID(1000000001L));
//        System.out.println(list1);
//        List<AccountBookManage> list2 = bookManageDAO.selectAll();
//        System.out.println(list2);
        AccountMessage message = messageDAO.selectByUID(new UID(1000000001L));
        System.out.println(message);
        // 长记性了，写sql的时候记得写as！！
    }
    @Test
    void testAccount(){

    }
}
