package tech.argentoaskia.bookzone.repository.typehandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Boolean.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class BooleanAndTinyintTypehandler extends BaseTypeHandler<Boolean> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        int p;
        if(aBoolean){
            p = (int) (1 + Math.random() * 7);
        }else{
            p = 0;
        }
        preparedStatement.setInt(i, p);
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
       int b = resultSet.getInt(s);
       return b > 0;
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int b = resultSet.getInt(i);
        return b > 0;
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int b = callableStatement.getInt(i);
        return b > 0;
    }
}
