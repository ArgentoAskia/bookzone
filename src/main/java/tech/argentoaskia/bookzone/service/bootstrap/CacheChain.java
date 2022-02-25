package tech.argentoaskia.bookzone.service.bootstrap;

import org.springframework.stereotype.Component;
import tech.argentoaskia.bookzone.repository.cache.CacheDAO;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import javax.servlet.Filter;

public interface CacheChain {
    boolean doInit();
}
