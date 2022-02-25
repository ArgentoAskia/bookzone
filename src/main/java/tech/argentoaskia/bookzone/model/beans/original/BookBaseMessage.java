package tech.argentoaskia.bookzone.model.beans.original;

import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.BookType;

import java.time.LocalDateTime;

public class BookBaseMessage {
    private BID bid;
    private String bookName;
    private String bookOtherName;
    private String bookCoverURL;
    private BookType type;
    private String introHTMLPath;
    private String bookAuthors;
    private LocalDateTime newUpdateTime;
    private int grade;
    private int collectionCounts;
    private int charterCounts;
    private int watchCounts;
    private int likeCounts;
    private int commentCounts;
    private LocalDateTime bookOnlineTime;

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

    public String getBookOtherName() {
        return bookOtherName;
    }

    public void setBookOtherName(String bookOtherName) {
        this.bookOtherName = bookOtherName;
    }

    public String getBookCoverURL() {
        return bookCoverURL;
    }

    public void setBookCoverURL(String bookCoverURL) {
        this.bookCoverURL = bookCoverURL;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public String getIntroHTMLPath() {
        return introHTMLPath;
    }

    public void setIntroHTMLPath(String introHTMLPath) {
        this.introHTMLPath = introHTMLPath;
    }

    public String getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(String bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public LocalDateTime getNewUpdateTime() {
        return newUpdateTime;
    }

    public void setNewUpdateTime(LocalDateTime newUpdateTime) {
        this.newUpdateTime = newUpdateTime;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCollectionCounts() {
        return collectionCounts;
    }

    public void setCollectionCounts(int collectionCounts) {
        this.collectionCounts = collectionCounts;
    }

    public int getCharterCounts() {
        return charterCounts;
    }

    public void setCharterCounts(int charterCounts) {
        this.charterCounts = charterCounts;
    }

    public int getWatchCounts() {
        return watchCounts;
    }

    public void setWatchCounts(int watchCounts) {
        this.watchCounts = watchCounts;
    }

    public int getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(int likeCounts) {
        this.likeCounts = likeCounts;
    }

    public int getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(int commentCounts) {
        this.commentCounts = commentCounts;
    }

    public LocalDateTime getBookOnlineTime() {
        return bookOnlineTime;
    }

    public void setBookOnlineTime(LocalDateTime bookOnlineTime) {
        this.bookOnlineTime = bookOnlineTime;
    }
}
