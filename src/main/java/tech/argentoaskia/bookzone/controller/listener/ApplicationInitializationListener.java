package tech.argentoaskia.bookzone.controller.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import tech.argentoaskia.bookzone.config.RedisConfig;
import tech.argentoaskia.bookzone.service.bootstrap.CacheChain;
import tech.argentoaskia.bookzone.utils.SpringUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class ApplicationInitializationListener implements ApplicationRunner{

    private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializationListener.class);

    private CacheChain chain;

    @Autowired
    public ApplicationInitializationListener(CacheChain chain) {
        this.chain = chain;
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("spring容器初始化完成");
        // 加载缓存
        logger.info("加载缓存");
        chain.doInit();
    }
}
