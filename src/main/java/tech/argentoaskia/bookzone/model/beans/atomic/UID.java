package tech.argentoaskia.bookzone.model.beans.atomic;

import tech.argentoaskia.bookzone.exception.InvalidIDTypeException;

public class UID extends IDType<Long> implements Type<Long> {

    public UID(Long l) {
        if(l < 10000000){
            l = l + 1000000000;
        }
        setId(l);
    }
    public UID(){}

    @Override
    public Long get() {
        return getId();
    }



    protected Long checkID(Long uid) {
        String strUid = String.valueOf(uid);
        if(strUid.length() != 10 || !strUid.startsWith("100")){
            throw new InvalidIDTypeException("此ID不是UID");
        }
        return uid;
    }
}
