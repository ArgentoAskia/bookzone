package tech.argentoaskia.bookzone.model.beans.original;

import tech.argentoaskia.bookzone.model.beans.atomic.UID;

import java.time.LocalDateTime;

public class AccountPrivateMessage {

    private UID uid;
    private UID uidFrom;
    private String userNameFrom;
    private LocalDateTime repeatTimeFrom;
    private String repeatContextFrom;
    private Boolean status;

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public UID getUidFrom() {
        return uidFrom;
    }

    public void setUidFrom(UID uidFrom) {
        this.uidFrom = uidFrom;
    }

    public String getUserNameFrom() {
        return userNameFrom;
    }

    public void setUserNameFrom(String userNameFrom) {
        this.userNameFrom = userNameFrom;
    }

    public LocalDateTime getRepeatTimeFrom() {
        return repeatTimeFrom;
    }

    public void setRepeatTimeFrom(LocalDateTime repeatTimeFrom) {
        this.repeatTimeFrom = repeatTimeFrom;
    }

    public String getRepeatContextFrom() {
        return repeatContextFrom;
    }

    public void setRepeatContextFrom(String repeatContextFrom) {
        this.repeatContextFrom = repeatContextFrom;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
