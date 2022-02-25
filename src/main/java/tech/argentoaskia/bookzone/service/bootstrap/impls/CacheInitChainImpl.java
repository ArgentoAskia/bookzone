package tech.argentoaskia.bookzone.service.bootstrap.impls;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import tech.argentoaskia.bookzone.controller.listener.ApplicationInitializationListener;
import tech.argentoaskia.bookzone.repository.cache.CacheDAO;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;
import tech.argentoaskia.bookzone.service.bootstrap.CacheChain;
import tech.argentoaskia.bookzone.service.bootstrap.CacheInit;
import tech.argentoaskia.bookzone.utils.SpringUtil;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

@Service
public class CacheInitChainImpl implements CacheChain {

    private static final Logger logger = LoggerFactory.getLogger(CacheInitChainImpl.class);
    private final Map<Double, CacheInit<DatabaseDAO<?>,CacheDAO>> map;
    private final SpringUtil springUtil;

    @Autowired
    public CacheInitChainImpl(SpringUtil springUtil){
        logger.info("缓存链初始化");
        map = new HashMap<>();
        logger.info("SpringUtil可用：{}", springUtil != null);
        this.springUtil = springUtil;
    }

    private String[] getClassName(Resource[] resources) throws IOException{
        String[] strings = new String[resources.length];
        for (int i = 0; i < resources.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(resources[i].getURI().toString());
            String tech = stringBuilder.substring(stringBuilder.indexOf("tech"),stringBuilder.length() - 6);
            tech = tech.replaceAll("\\/",".");
            strings[i] = tech;
        }
        logger.info("获取类名：{}", (Object) strings);
        return strings;
    }

    @SuppressWarnings("all")
    private void collectCacheInit() throws IOException, ClassNotFoundException {
        // !!!
        logger.info("扫包搜集CacheInit操作，初始化XXXCacheInit类");
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourcePatternResolver.getResources("classpath*:tech/argentoaskia/bookzone/service/bootstrap/cacheInit/**/*.class");
        String[] className = getClassName(resources);
        for (String str:
             className) {
            Class<?> aClass = Class.forName(str, false, CacheInit.class.getClassLoader());
            CacheInit<DatabaseDAO<?>, CacheDAO> cacheInit = springUtil.getBean((Class<CacheInit<DatabaseDAO<?>, CacheDAO>>)aClass);
            logger.info("CacheType:{}", cacheInit.getClass().getSimpleName());
            map.put(cacheInit.order(), cacheInit);
        }
    }
    @Override
    public boolean doInit() {
        try {
            collectCacheInit();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Set<Double> set = map.keySet();
        // 如果set空则不需要初始化
        if(set.isEmpty()){
            return false;
        }
        Double[] doubles = set.toArray(new Double[0]);
        // 排序
        Arrays.sort(doubles);
        boolean loop;
        int i = 0;
        for (Double aDouble : doubles) {

            CacheInit<DatabaseDAO<?>, CacheDAO> next = map.get(aDouble);
            logger.info("正在初始化：{},当前排序：{}", next, i);
            loop = next.init(next.getDatabaseDAO(), next.getCacheDAO(), i++);
            if (!loop) {
                logger.warn("初始化终止");
                return false;
            }
        }
        logger.info("初始化完毕");
        return false;
    }
}
