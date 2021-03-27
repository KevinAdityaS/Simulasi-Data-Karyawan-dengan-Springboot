package com.Batch8Ujian3.Main.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TitleRowMapper implements RowMapper<Title>{

	@Override
	public Title mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Title title = new Title();
		title.setWorker_Ref_Id(rs.getString("worker_ref_id"));
		title.setWorker_Title(rs.getString("worker_title"));
		title.setAffected_From(rs.getString("affected_from"));
		
		return title;
		
	}
	
}
