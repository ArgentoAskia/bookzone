package tech.argentoaskia.bookzone.model.beans.atomic;

import tech.argentoaskia.bookzone.exception.InvalidIDTypeException;

import java.io.Serializable;

public class CID extends IDType<Integer> implements Type<Integer> {

    private Integer integer;

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    public CID(Integer id) {
       setId(id);
    }

    public CID() {
        super();
    }

    @Override
    protected Integer checkID(Integer id) {
        if(id < 0){
            throw new InvalidIDTypeException("CID不为负数");
        }
        return id;
    }

    @Override
    public Integer get() {
        return getId();
    }
}
