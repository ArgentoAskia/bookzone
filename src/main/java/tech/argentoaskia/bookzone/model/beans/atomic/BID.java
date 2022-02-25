package tech.argentoaskia.bookzone.model.beans.atomic;

import tech.argentoaskia.bookzone.exception.InvalidIDTypeException;

import java.io.Serializable;

public class BID extends IDType<Long> implements Type<Long> {

    public BID(Long id) {
        if(id < 10000000){
            id = id + 10000000;
        }
        setId(id);
    }

    public BID() {
    }

    @Override
    public Long get() {
        return getId();
    }

    @Override
    protected Long checkID(Long id) {
        String strUid = String.valueOf(id);
        if(strUid.length() != 8 || id < 0){
            throw new InvalidIDTypeException("此ID不是BID");
        }
        return id;
    }
}
