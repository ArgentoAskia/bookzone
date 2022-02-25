package tech.argentoaskia.bookzone.repository.mapper.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.original.AccountBookManage;
import tech.argentoaskia.bookzone.model.beans.original.UserMessage;
import tech.argentoaskia.bookzone.repository.mapper.DatabaseDAO;

import java.util.List;

@Repository
@Mapper
public interface AccountBookManageDAO extends DatabaseDAO<AccountBookManage> {
    List<AccountBookManage> selectAll();

    /**
     * 获取用户参与制作的所有小说
     * @param uid
     * @return UID相同的AccountBookManage类
     */
    List<AccountBookManage> selectByUID(UID uid);

    /**
     * 获取该书籍相关的已在网站注册的作者或者译者
     * @param bid
     * @return BID相同的AccountBookManage类
     */
    List<AccountBookManage> selectByBID(BID bid);

    /**
     * 获取某个作者的某本书的相关信息
     * @param uid
     * @param bid
     * @return
     */
    AccountBookManage selectByPrimary(@Param("uid") UID uid,@Param("bid") BID bid);
    List<AccountBookManage> selectByOriginalType(AccountBookManage originalType);

    /**
     * 多个申请通过的时候使用
     * @param userMessage
     * @return
     */
    int insertMore(AccountBookManage ...userMessage);

    /**
     * 当用户申请翻译或者撰写某本轻小说的时候使用的插入语句
     * @param originalType
     * @return
     */
    @Override
    int insert(AccountBookManage originalType);

    /**
     * 在联合翻译的时候，当某个作者退出该书的翻译的时候调用
     * 通用删除
     * @param originalType
     * @return
     */
    @Override
    int delete(AccountBookManage originalType);

    /**
     * 当某个用户注销的时候，调用删除该用户的所有管理信息
     * @param bid
     * @return
     */
    int deleteByUID(UID bid);

    /**
     * 当某本注销的时候，删除所有的该书管理信息
     * @param uid
     * @return
     */
    int deleteByBID(BID uid);


    /**
     * 通常用于更新书的状态，更新书的接手工作，更改书的名称（外键？）等。
     * @param userMessage
     * @return
     */
    int update(AccountBookManage userMessage);
}
