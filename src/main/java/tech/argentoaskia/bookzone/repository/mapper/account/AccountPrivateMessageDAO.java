package tech.argentoaskia.bookzone.repository.mapper.account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.original.AccountPrivateMessage;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import java.util.List;
@Repository
@Mapper
public interface AccountPrivateMessageDAO extends DatabaseDAO<AccountPrivateMessage> {

    @Override
    List<AccountPrivateMessage> selectAll();

    @Override
    List<AccountPrivateMessage> selectByOriginalType(AccountPrivateMessage originalType);
    List<AccountPrivateMessage> selectByCommunication(UID toUid, UID fromUid);
    int selectUnReadMessageCount(UID touid);


    @Override
    int insert(AccountPrivateMessage originalType);

    @Override
    int update(AccountPrivateMessage originalType);

    @Override
    int delete(AccountPrivateMessage originalType);
}
