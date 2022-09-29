package com.mozzart.obuka.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.mozzart.obuka.domain.Origin;

public class OriginTypeHandler implements TypeHandler<Origin> {

	@Override
	public void setParameter(PreparedStatement ps, int i, Origin parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Origin getResult(ResultSet rs, String columnName) throws SQLException {
		return Origin.getById(rs.getInt(columnName));
	}

	@Override
	public Origin getResult(ResultSet rs, int columnIndex) throws SQLException {
		return Origin.getById(rs.getInt(columnIndex));
	}

	@Override
	public Origin getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}