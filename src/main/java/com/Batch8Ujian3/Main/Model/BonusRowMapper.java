package com.Batch8Ujian3.Main.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BonusRowMapper implements RowMapper<Bonus>{

	@Override
	public Bonus mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Bonus bonus = new Bonus();
		bonus.setWorker_Ref_Id(rs.getString("worker_ref_id"));
		bonus.setBonus_Date(rs.getString("bonus_date"));
		bonus.setBonus_Amount(rs.getInt("bonus_amount"));
		
		return bonus;
		
	}
	
}
