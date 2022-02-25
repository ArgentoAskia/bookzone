package tech.argentoaskia.bookzone.repository.mapper.account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tech.argentoaskia.bookzone.model.beans.original.AccountEXPRecord;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import java.util.List;

@Repository
@Mapper
public interface AccountEXPRecordDAO extends DatabaseDAO<AccountEXPRecord> {

    @Override
    List<AccountEXPRecord> selectAll();

    @Override
    List<AccountEXPRecord> selectByOriginalType(AccountEXPRecord originalType);

    @Override
    int insert(AccountEXPRecord originalType);

    @Override
    int update(AccountEXPRecord originalType);

    @Override
    int delete(AccountEXPRecord originalType);
}
