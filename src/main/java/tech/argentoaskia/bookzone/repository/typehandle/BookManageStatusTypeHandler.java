package tech.argentoaskia.bookzone.repository.typehandle;

import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;
import tech.argentoaskia.bookzone.model.beans.atomic.BookManageStatus;

@MappedTypes(BookManageStatus.class)
public class BookManageStatusTypeHandler extends EnumTypeHandler<BookManageStatus> {
    public BookManageStatusTypeHandler(Class<BookManageStatus> type) {
        super(type);
    }
}
