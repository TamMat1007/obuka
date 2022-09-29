
package com.mozzart.obuka.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.mozzart.obuka.domain.ComparationCriteria;

public class ComparationCriteriaTypeHandler implements TypeHandler<ComparationCriteria> {

	@Override
	public void setParameter(PreparedStatement ps, int i, ComparationCriteria parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub	
	}
	@Override
	public ComparationCriteria getResult(ResultSet rs, String columnName) throws SQLException {
		return ComparationCriteria.getById(rs.getInt(columnName));
	}

	@Override
	public ComparationCriteria getResult(ResultSet rs, int columnIndex) throws SQLException {
		return ComparationCriteria.getById(rs.getInt(columnIndex));
	}

	@Override
	public ComparationCriteria getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}