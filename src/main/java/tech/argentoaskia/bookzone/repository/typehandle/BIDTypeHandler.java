package tech.argentoaskia.bookzone.repository.typehandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import tech.argentoaskia.bookzone.model.beans.atomic.BID;
import tech.argentoaskia.bookzone.model.beans.atomic.UID;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@MappedTypes(BID.class)
public class BIDTypeHandler extends BaseTypeHandler<BID> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, BID bid, JdbcType jdbcType) throws SQLException {
        int integer = Math.toIntExact(Objects.requireNonNull(bid.getId(), "BID不能为null，请调试!"));
        preparedStatement.setInt(i, integer);
    }

    @Override
    public BID getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int anInt = resultSet.getInt(s);
        Long l  = (long) anInt;
        return new BID(l);
    }

    @Override
    public BID getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int anInt = resultSet.getInt(i);
        Long l  = (long) anInt;
        return new BID(l);
    }

    @Override
    public BID getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int anInt = callableStatement.getInt(i);
        Long l  = (long) anInt;
        return new BID(l);
    }
}
