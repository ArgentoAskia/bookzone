package tech.argentoaskia.bookzone.model.beans.visual;

import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.BookManageStatus;

import java.io.Serializable;

public class AccountBookManageVisual implements Serializable {

    private static final long serialVersionUID = -6962045049205640765L;

    private String bookName;
    private BID bid;

    public BID getBid() {
        return bid;
    }

    public void setBid(BID bid) {
        this.bid = bid;
    }

    private BookManageStatus status;

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
