package tech.argentoaskia.bookzone.model.beans.atomic;

import java.io.Serializable;

public abstract class IDType<T> implements Serializable {

    private static final long serialVersionUID = 3653964240229463103L;
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = checkID(id);
    }

    protected abstract T checkID(T id);
}
