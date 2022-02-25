package tech.argentoaskia.bookzone.model.beans.original;

import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.BookStatus;

public class BookSettings {
    private BID bid;
    private BookStatus status;
    private Boolean openEdit;
    private Boolean openComment;
    private Boolean openArticle;
    // 用于存储访问密码
    private String remark;

    public BID getBid() {
        return bid;
    }

    public void setBid(BID bid) {
        this.bid = bid;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Boolean getOpenEdit() {
        return openEdit;
    }

    public void setOpenEdit(Boolean openEdit) {
        this.openEdit = openEdit;
    }

    public Boolean getOpenComment() {
        return openComment;
    }

    public void setOpenComment(Boolean openComment) {
        this.openComment = openComment;
    }

    public Boolean getOpenArticle() {
        return openArticle;
    }

    public void setOpenArticle(Boolean openArticle) {
        this.openArticle = openArticle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
