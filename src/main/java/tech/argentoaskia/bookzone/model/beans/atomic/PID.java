package tech.argentoaskia.bookzone.model.beans.atomic;

import tech.argentoaskia.bookzone.exception.InvalidIDTypeException;

import java.io.Serializable;

public class PID extends IDType<Long> implements Type<Long>{

    public PID(Long id) {
        if(id < 100000){
            id = id + 100000;
        }
        setId(id);
    }

    public PID() {
    }

    @Override
    protected Long checkID(Long id) {
        String strUid = String.valueOf(id);
        if(strUid.length() != 6 || id < 0){
            throw new InvalidIDTypeException("此ID不是PID");
        }
        return id;
    }

    @Override
    public Long get() {
        return getId();
    }
}
