package tech.argentoaskia.bookzone.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import tech.argentoaskia.bookzone.model.beans.atomic.BookManageStatus;
import tech.argentoaskia.bookzone.model.beans.original.AccountBookManage;

public class MsgDigestUtilTest {


    @Test
    public void testEnum(){
        BookManageStatus bookManageStatus = Enum.valueOf(BookManageStatus.class, "ONLINE");
        System.out.println(bookManageStatus);
    }
    @Test
    public void admin(){
        System.out.println(MsgDigestUtil.digest("admin".getBytes(), MsgDigestUtil.MsgDigestAlgorithm.MD5, MsgDigestUtil.stringType));
        System.out.println(getClass().getName());
        System.out.println(getClass().getSimpleName());
    }
    @Test
    public void TestMDAlgo(){
        String text = "su123456789";
        String md5 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.MD5, MsgDigestUtil.stringType);
        System.out.println("MD5 digest:" + md5);
        String SHA3_224 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.SHA3_224, MsgDigestUtil.stringType);
        System.out.println("SHA3_224 digest:" + SHA3_224);
        String SHA3_256 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.SHA3_256, MsgDigestUtil.stringType);
        System.out.println("SHA3_256 digest:" + SHA3_256);
        String SHA3_384 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.SHA3_384, MsgDigestUtil.stringType);
        System.out.println("SHA3_384 digest:" + SHA3_384);
        String SHA3_512 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.SHA3_512, MsgDigestUtil.stringType);
        System.out.println("SHA3_512 digest:" + SHA3_512);
        String SHA_224 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.SHA_224, MsgDigestUtil.stringType);
        System.out.println("SHA_224 digest:" + SHA_224);
        String SHA_256 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.SHA_256, MsgDigestUtil.stringType);
        System.out.println("SHA_256 digest:" + SHA_256);
        String SHA_384 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.SHA_384, MsgDigestUtil.stringType);
        System.out.println("SHA_384 digest:" + SHA_384);
        String SHA_512 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.SHA_512, MsgDigestUtil.stringType);
        System.out.println("SHA_512 digest:" + SHA_512);
    }


    @Test
    public void TestJedisConnection(){
        Jedis jedis = new Jedis("localhost", 6379, 1000000);
        System.out.println(jedis.ping());
    }
}
