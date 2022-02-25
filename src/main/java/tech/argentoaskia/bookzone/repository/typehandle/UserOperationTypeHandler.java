package tech.argentoaskia.bookzone.repository.typehandle;

import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;
import tech.argentoaskia.bookzone.model.beans.atomic.UserOperation;

@MappedTypes(UserOperation.class)
public class UserOperationTypeHandler extends EnumTypeHandler<UserOperation> {
    public UserOperationTypeHandler(Class<UserOperation> type) {
        super(type);
    }
}
