package com.Batch8Ujian3.Main.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeptInfoRowMapper implements RowMapper<DeptInfo>{

	@Override
	public DeptInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		DeptInfo deptinfo = new DeptInfo();
		deptinfo.setDepartement(rs.getString("departement"));
		deptinfo.setNumber_Of_Workers(rs.getInt("number_of_workers"));
		
		return deptinfo;
		
	}
	
}
