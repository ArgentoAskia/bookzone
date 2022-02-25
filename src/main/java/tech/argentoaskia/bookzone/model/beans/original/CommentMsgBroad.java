package tech.argentoaskia.bookzone.model.beans.original;

import tech.argentoaskia.bookzone.model.beans.atomic.Icon;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;

import java.time.LocalDateTime;

public class CommentMsgBroad {
    private UID uid;
    private int floors;
    private String context;
    private String name;
    private LocalDateTime time;
    private int refFloor;
    private Icon iconURL;
    private int like;

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
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

    public int getRefFloor() {
        return refFloor;
    }

    public void setRefFloor(int refFloor) {
        this.refFloor = refFloor;
    }

    public Icon getIconURL() {
        return iconURL;
    }

    public void setIconURL(Icon iconURL) {
        this.iconURL = iconURL;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
