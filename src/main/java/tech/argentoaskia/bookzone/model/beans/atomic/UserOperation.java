package tech.argentoaskia.bookzone.model.beans.atomic;

import org.apache.ibatis.type.NStringTypeHandler;

import java.io.Serializable;

public enum UserOperation implements Serializable {
    login("login"),
    post("post"),
    article("article"),
    reading("reading");
    private String op;

    UserOperation(String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }
}
