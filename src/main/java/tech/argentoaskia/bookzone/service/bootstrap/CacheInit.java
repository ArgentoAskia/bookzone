package tech.argentoaskia.bookzone.service.bootstrap;

import tech.argentoaskia.bookzone.repository.cache.CacheDAO;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

public interface CacheInit<T extends DatabaseDAO<?>, C extends CacheDAO> {
    boolean init(T dbDAO, C cacheDAO, int i);
    T getDatabaseDAO();
    C getCacheDAO();
    Double order();
}
