package tech.argentoaskia.bookzone.model.beans.original;

import java.util.Map;

public class AccountSecurity {
    private Long UID;
    private Map<String, String> QAS;


    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Map<String, String> getQAS() {
        return QAS;
    }

    public void setQAS(Map<String, String> QAS) {
        this.QAS = QAS;
    }
}
