package tech.argentoaskia.bookzone.repository.mapper.account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.original.AccountSecurity;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import java.util.List;

@Repository
@Mapper
public interface AccountSecurityDAO extends DatabaseDAO<AccountSecurity> {

    @Override
    List<AccountSecurity> selectAll();

    @Override
    List<AccountSecurity> selectByOriginalType(AccountSecurity originalType);

    @Override
    int update(AccountSecurity originalType);

    @Override
    int delete(AccountSecurity originalType);

    int insert(AccountSecurity securityMessage);
    int deleteByUID(Long UID);
    int updateByUID(Long UID);
    List<AccountSecurity> selectByUID(UID uid);
}
