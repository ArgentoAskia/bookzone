package tech.argentoaskia.bookzone.repository.typehandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import tech.argentoaskia.bookzone.model.beans.atomic.CID;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(CID.class)
public class CIDTypeHandler extends BaseTypeHandler<CID> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, CID cid, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, cid.getId());
    }

    @Override
    public CID getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int anInt = resultSet.getInt(s);
        return new CID(anInt);
    }

    @Override
    public CID getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int anInt = resultSet.getInt(i);
        return new CID(anInt);
    }

    @Override
    public CID getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int anInt = callableStatement.getInt(i);
        return new CID(anInt);
    }
}
