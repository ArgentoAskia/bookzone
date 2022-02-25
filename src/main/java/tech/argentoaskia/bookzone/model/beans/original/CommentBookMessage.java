package tech.argentoaskia.bookzone.model.beans.original;

import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.Icon;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;

import java.time.LocalDateTime;

public class CommentBookMessage {
    private BID bid;
    private int floors;
    private String context;
    private UID uid;
    private Icon icon;
    private String name;
    private LocalDateTime time;
    private int refFloors;
    private int like;

    public BID getBid() {
        return bid;
    }

    public void setBid(BID bid) {
        this.bid = bid;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getRefFloors() {
        return refFloors;
    }

    public void setRefFloors(int refFloors) {
        this.refFloors = refFloors;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
