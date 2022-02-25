package tech.argentoaskia.bookzone.repository.mapper.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.springframework.stereotype.Repository;
import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.original.AccountCollections;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Mapper
public interface AccountCollectionsDAO extends DatabaseDAO<AccountCollections> {
    @Override
    List<AccountCollections> selectAll();

    @Override
    List<AccountCollections> selectByOriginalType(AccountCollections originalType);

    List<AccountCollections> selectByUID(UID uid);
    LocalDateTime selectNewUpdateTime(@Param("uid") UID uid, @Param("bid") BID bid);


    @Override
    int insert(AccountCollections originalType);

    @Override
    int update(AccountCollections originalType);
    int updateLastUpdateTime(@Param("uid") UID uid, @Param("bid") BID bid, @Param("newUpdate")LocalDateTime newUpdateTime);

    @Override
    int delete(AccountCollections originalType);

    /**
     * 获取书籍搜藏数量，后期放在BookMapper中
     * @param bid
     * @return
     */
    int getBookCollectionsCount(BID bid);

    int getCollectionsUpdate(UID uid);
}
