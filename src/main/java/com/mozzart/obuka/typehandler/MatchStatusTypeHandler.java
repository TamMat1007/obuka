package com.mozzart.obuka.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.mozzart.obuka.domain.MatchStatus;

public class MatchStatusTypeHandler implements TypeHandler<MatchStatus> {

	@Override
	public void setParameter(PreparedStatement ps, int i, MatchStatus parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MatchStatus getResult(ResultSet rs, String columnName) throws SQLException {
		return MatchStatus.getById(rs.getInt(columnName));
	}

	@Override
	public MatchStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		return MatchStatus.getById(rs.getInt(columnIndex));
	}

	@Override
	public MatchStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}