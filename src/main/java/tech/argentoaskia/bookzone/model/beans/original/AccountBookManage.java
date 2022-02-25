package tech.argentoaskia.bookzone.model.beans.original;

import org.apache.ibatis.type.EnumTypeHandler;
import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.BookManageStatus;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;

public class AccountBookManage {
    private UID uid;
    private BID bid;
    private String bookName;
    private BookManageStatus status;

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public BID getBid() {
        return bid;
    }

    public void setBid(BID bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookManageStatus getStatus() {
        return status;
    }

    public void setStatus(BookManageStatus status) {
        this.status = status;
    }
}
