package com.Batch8Ujian3.Main.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WorkerRowMapper implements RowMapper<Worker>{

	@Override
	public Worker mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Worker worker = new Worker();
		worker.setWorker_Id(rs.getString("worker_id"));
		worker.setFirst_Name(rs.getString("first_name"));
		worker.setLast_Name(rs.getString("last_name"));
		worker.setSalary(rs.getInt("salary"));
		worker.setJoining_Date(rs.getString("joining_date"));
		worker.setDepartement(rs.getString("departement"));
		
		return worker;
		
	}
	
}
