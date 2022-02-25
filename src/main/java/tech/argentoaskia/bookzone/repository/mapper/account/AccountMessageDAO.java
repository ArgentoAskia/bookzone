package tech.argentoaskia.bookzone.repository.mapper.account;


import org.apache.ibatis.annotations.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.original.AccountMessage;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import java.util.List;

/**
 * DAO类。
 * 该类只负责最原始的数据处理和SQL执行。
 */

@Repository
@Mapper
public interface AccountMessageDAO extends DatabaseDAO<AccountMessage> {

    @Override
    int insert(AccountMessage originalType);

    int register(@Param("firstRecord")Boolean isFirst, @Param("uName") String uName, @Param("uEmail") String uEmail, @Param("uPassword") String uPassword);
    int registerByUID(@Param("uid")Long UID, @Param("uName") String uName,@Param("uEmail") String uEmail,@Param("uPassword") String uPassword);

    @Select("SELECT LAST_INSERT_ID()")
    Long returnInsertUID();


    @Override
    int delete(AccountMessage originalType);

    @Delete("DELETE FROM user_account_message where UID = #{uid}}")
    int deleteByUID(@Param("uid") Long uid);

    @Override
    int update(AccountMessage originalType);

    @Override
    List<AccountMessage> selectAll();
    @Override
    List<AccountMessage> selectByOriginalType(AccountMessage originalType);

    AccountMessage selectByUID(UID uid);

    /**
     *  登录校验方法
     * @param UID
     * @return
     */
    String checkAccountByUID(@Param("uid")Long UID);
    String checkAccountByName(@Param("uname")String name);
    String checkAccountByEmail(@Param("uemail")String email);
}
