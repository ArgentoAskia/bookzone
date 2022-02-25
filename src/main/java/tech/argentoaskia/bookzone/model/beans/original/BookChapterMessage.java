package tech.argentoaskia.bookzone.model.beans.original;

import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.CID;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;

import java.time.LocalDateTime;

public class BookChapterMessage {

    private BID bid;
    private CID cid;
    private UID uid;
    private String chapterTitle;
    private String chapterContextHTMLPath;
    private int chapterLetterCount;
    private LocalDateTime publishTime;
    private int likes;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getChapterContextHTMLPath() {
        return chapterContextHTMLPath;
    }

    public void setChapterContextHTMLPath(String chapterContextHTMLPath) {
        this.chapterContextHTMLPath = chapterContextHTMLPath;
    }

    public int getChapterLetterCount() {
        return chapterLetterCount;
    }

    public void setChapterLetterCount(int chapterLetterCount) {
        this.chapterLetterCount = chapterLetterCount;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }
}
