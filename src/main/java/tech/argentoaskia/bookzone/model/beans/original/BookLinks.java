package tech.argentoaskia.bookzone.model.beans.original;

import tech.argentoaskia.bookzone.model.beans.atomic.BID;

public class BookLinks {
    private BID bid;
    private String linksName;
    private String linkURL;

    public BID getBid() {
        return bid;
    }

    public void setBid(BID bid) {
        this.bid = bid;
    }

    public String getLinksName() {
        return linksName;
    }

    public void setLinksName(String linksName) {
        this.linksName = linksName;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }
}
