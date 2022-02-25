package tech.argentoaskia.bookzone.repository.mapper.account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tech.argentoaskia.bookzone.model.beans.original.AccountReadingRecord;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import java.util.List;

@Repository
@Mapper
public interface AccountReadingRecordDAO extends DatabaseDAO<AccountReadingRecord> {
    @Override
    List<AccountReadingRecord> selectAll();

    @Override
    List<AccountReadingRecord> selectByOriginalType(AccountReadingRecord originalType);

    @Override
    int insert(AccountReadingRecord originalType);

    @Override
    int update(AccountReadingRecord originalType);

    @Override
    int delete(AccountReadingRecord originalType);
}
