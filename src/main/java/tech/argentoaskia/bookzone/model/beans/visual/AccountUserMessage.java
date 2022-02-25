package tech.argentoaskia.bookzone.model.beans.visual;

import tech.argentoaskia.bookzone.model.beans.atomic.Icon;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AccountUserMessage implements Serializable {

    private static final long serialVersionUID = -3143741533501289406L;
    private UID uid;

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    private String name;
    private Icon icon;
    private String email;
    private Integer age;
    private Boolean ableCom;
    private String introduction;
    private LocalDateTime registedTime;
    private Integer lv;
    private Integer exp;
    private Integer coins;

    private int countForPrivateMessage;
    private int countForCollectionsUpdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getAbleCom() {
        return ableCom;
    }

    public void setAbleCom(Boolean ableCom) {
        this.ableCom = ableCom;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public LocalDateTime getRegistedTime() {
        return registedTime;
    }

    public void setRegistedTime(LocalDateTime registedTime) {
        this.registedTime = registedTime;
    }

    public Integer getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = lv;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public int getCountForPrivateMessage() {
        return countForPrivateMessage;
    }

    public void setCountForPrivateMessage(int countForPrivateMessage) {
        this.countForPrivateMessage = countForPrivateMessage;
    }

    public int getCountForCollectionsUpdate() {
        return countForCollectionsUpdate;
    }

    public void setCountForCollectionsUpdate(int countForCollectionsUpdate) {
        this.countForCollectionsUpdate = countForCollectionsUpdate;
    }

    @Override
    public String toString() {
        return "AccountUserMessage{" +
                super.toString() +","+
                "uid=" + uid.get() +
                ", name='" + name + '\'' +
                ", icon=" + icon +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", ableCom=" + ableCom +
                ", introduction='" + introduction + '\'' +
                ", registedTime=" + registedTime +
                ", lv=" + lv +
                ", exp=" + exp +
                ", coins=" + coins +
                ", countForPrivateMessage=" + countForPrivateMessage +
                ", countForCollectionsUpdate=" + countForCollectionsUpdate +
                '}';
    }
}
