package tech.argentoaskia.bookzone.model.beans.original;

import tech.argentoaskia.bookzone.model.beans.atomic.UID;
import tech.argentoaskia.bookzone.model.beans.atomic.UserOperation;

import java.time.LocalDateTime;

public class AccountEXPRecord {

    private UID uid;
    private UserOperation operation;
    private LocalDateTime opTime;
    private Integer expGet;

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public UserOperation getOperation() {
        return operation;
    }

    public void setOperation(UserOperation operation) {
        this.operation = operation;
    }

    public LocalDateTime getOpTime() {
        return opTime;
    }

    public void setOpTime(LocalDateTime opTime) {
        this.opTime = opTime;
    }

    public Integer getExpGet() {
        return expGet;
    }

    public void setExpGet(Integer expGet) {
        this.expGet = expGet;
    }
}
