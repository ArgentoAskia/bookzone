package tech.argentoaskia.bookzone.model.beans.original;


import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.CID;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;

import java.time.LocalDateTime;
import java.util.Date;

// visual view add update 字段
public class AccountCollections {
    private UID uid;
    private BID bid;
    private CID cid;
    private Date bookLastWatchTime;
    private LocalDateTime bookLastUpdateTime;
    private LocalDateTime bookNewUpdateTime;

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

    public CID getCid() {
        return cid;
    }

    public void setCid(CID cid) {
        this.cid = cid;
    }

    public Date getBookLastWatchTime() {
        return bookLastWatchTime;
    }

    public void setBookLastWatchTime(Date bookLastWatchTime) {
        this.bookLastWatchTime = bookLastWatchTime;
    }

    public LocalDateTime getBookLastUpdateTime() {
        return bookLastUpdateTime;
    }

    public void setBookLastUpdateTime(LocalDateTime bookLastUpdateTime) {
        this.bookLastUpdateTime = bookLastUpdateTime;
    }

    public LocalDateTime getBookNewUpdateTime() {
        return bookNewUpdateTime;
    }

    public void setBookNewUpdateTime(LocalDateTime bookNewUpdateTime) {
        this.bookNewUpdateTime = bookNewUpdateTime;
    }
}
