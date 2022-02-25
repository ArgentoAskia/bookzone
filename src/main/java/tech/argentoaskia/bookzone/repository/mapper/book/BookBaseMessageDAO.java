package tech.argentoaskia.bookzone.repository.mapper.book;

import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.original.BookBaseMessage;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import java.util.List;

public interface BookBaseMessageDAO extends DatabaseDAO<BookBaseMessage> {
    int getCollectionsUpdate(UID uid);

    @Override
    List<BookBaseMessage> selectAll();

    @Override
    List<BookBaseMessage> selectByOriginalType(BookBaseMessage originalType);

    @Override
    int insert(BookBaseMessage originalType);

    @Override
    int update(BookBaseMessage originalType);

    @Override
    int delete(BookBaseMessage originalType);
}
