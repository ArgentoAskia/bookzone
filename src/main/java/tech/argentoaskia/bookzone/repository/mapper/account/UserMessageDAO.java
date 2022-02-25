package tech.argentoaskia.bookzone.repository.mapper.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tech.argentoaskia.bookzone.model.beans.original.UserMessage;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import java.util.List;

@Repository
@Mapper
public interface UserMessageDAO extends DatabaseDAO<UserMessage> {

    List<UserMessage> selectAll();
    UserMessage selectByUID(@Param("uid") Long uid);
    @Override
    List<UserMessage> selectByOriginalType(UserMessage originalType);

    @Override
    int insert(UserMessage userMessage);
    @Override
    int update(UserMessage userMessage);

    int deleteByUID(Long UID);



    @Override
    int delete(UserMessage originalType);
}
