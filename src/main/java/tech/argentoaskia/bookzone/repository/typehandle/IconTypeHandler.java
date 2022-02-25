package tech.argentoaskia.bookzone.repository.typehandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import tech.argentoaskia.bookzone.model.beans.atomic.Icon;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Icon.class)
public class IconTypeHandler extends BaseTypeHandler<Icon> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Icon icon, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, icon.getImageURL());
    }

    @Override
    public Icon getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Icon icon = new Icon();
        String url = resultSet.getString(s);
        try {
            icon.setImage(url);
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return icon;
    }

    @Override
    public Icon getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Icon icon = new Icon();
        String url = resultSet.getString(i);
        try {
            icon.setImage(url);
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return icon;
    }

    @Override
    public Icon getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Icon icon = new Icon();
        String url = callableStatement.getString(i);
        try {
            icon.setImage(url);
        } catch (IOException e) {
            throw new SQLException(e);
        }
        return icon;
    }
}
