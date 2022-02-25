package tech.argentoaskia.bookzone.model.beans.visual;

import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.CID;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AccountCollectionsVisual implements Serializable {

    private static final long serialVersionUID = -5626901890568428464L;
    private BID bid;
    private CID cid;
    private LocalDateTime lastWatchTime;
    private LocalDateTime newUpdateTime;
    private Boolean isNewUpdate;

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

    public LocalDateTime getLastWatchTime() {
        return lastWatchTime;
    }

    public void setLastWatchTime(LocalDateTime lastWatchTime) {
        this.lastWatchTime = lastWatchTime;
    }

    public LocalDateTime getNewUpdateTime() {
        return newUpdateTime;
    }

    public void setNewUpdateTime(LocalDateTime newUpdateTime) {
        this.newUpdateTime = newUpdateTime;
    }

    public Boolean getNewUpdate() {
        return isNewUpdate;
    }

    public void setNewUpdate(Boolean newUpdate) {
        isNewUpdate = newUpdate;
    }
}
