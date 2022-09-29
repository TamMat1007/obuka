package com.mozzart.obuka.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.mozzart.obuka.domain.WinnStatus;

public class WinnStatusTypeHandler implements TypeHandler<WinnStatus> {

	@Override
	public void setParameter(PreparedStatement ps, int i, WinnStatus parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WinnStatus getResult(ResultSet rs, String columnName) throws SQLException {
		return WinnStatus.getById(rs.getInt(columnName));
	}

	@Override
	public WinnStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		return WinnStatus.getById(rs.getInt(columnIndex));
	}

	@Override
	public WinnStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}