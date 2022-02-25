package tech.argentoaskia.bookzone.utils;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 信息摘要(Message Digest)工具.
 *
 * @author Askia
 * @version 1.0
 * @support www.argentoaskia.tech
 */

public class MsgDigestUtil {

    public enum MsgDigestAlgorithm{
        SHA_224("SHA-256"),
        SHA_256("SHA-256"),
        SHA_384("SHA-384"),
        SHA_512("SHA-512"),
        SHA_512_224("SHA-512/224"),
        SHA_512_256("SHA-512/256"),
        SHA3_224("SHA3-224"),
        SHA3_256("SHA3-256"),
        SHA3_384("SHA3-384"),
        SHA3_512("SHA3-512"),
        MD5("MD5");
        private final String value;
        MsgDigestAlgorithm(String value) {
            this.value = value;
        }
        public String getValue(){
            return value;
        }
    }

    public static final Class<byte[]> bytesType = byte[].class;
    public static final Class<String> stringType = String.class;

    @SuppressWarnings("All")
    public static <T> T digest(byte[] data, MsgDigestAlgorithm algorithm, Class<T> returnType){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm.value);
            messageDigest.update(data);
            byte[] result = messageDigest.digest();
            if (returnType.equals(bytesType)){
                return (T) result;
            }else if(returnType.equals(stringType)){
                return (T) HexUtils.toHexString(result);
            }else{
                throw new RuntimeException("no such return type! type：" + returnType.getName());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("something wrong with function!");
        }
    }
    private static byte[] getData(Object obj){
        return null;
    }
}
