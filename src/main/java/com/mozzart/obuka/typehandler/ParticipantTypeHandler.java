package com.mozzart.obuka.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.mozzart.obuka.domain.ParticipantType;

public class ParticipantTypeHandler implements TypeHandler<ParticipantType> {

	@Override
	public void setParameter(PreparedStatement ps, int i, ParticipantType parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ParticipantType getResult(ResultSet rs, String columnName) throws SQLException {
		return ParticipantType.getById(rs.getInt(columnName));
	}

	@Override
	public ParticipantType getResult(ResultSet rs, int columnIndex) throws SQLException {
		return ParticipantType.getById(rs.getInt(columnIndex));
	}

	@Override
	public ParticipantType getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}