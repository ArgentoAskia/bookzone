package tech.argentoaskia.bookzone.repository.mapper;

import java.util.List;

public interface DatabaseDAO<original>{
    List<original> selectAll();
    List<original> selectByOriginalType(original originalType);
    int insert(original originalType);
    int update(original originalType);
    int delete(original originalType);
}
