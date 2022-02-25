package tech.argentoaskia.bookzone.model.beans.atomic;

import java.io.Serializable;

public enum BookManageStatus implements Type<String>, Serializable {

    support("support"),
    checking("checking"),
    online("online"),
    out("out");

    private String status;

    BookManageStatus(String s){
        status = s;
    }


    @Override
    public String get() {
        return status;
    }
}
