package tech.argentoaskia.bookzone.model.beans.redis;

public interface RedisKeyValueModel {
    String key();
    Object value();
    default String type(){
        return this.getClass().getSimpleName();
    }
}
