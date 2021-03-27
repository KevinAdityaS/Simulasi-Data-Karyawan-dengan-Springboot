package com.Batch8Ujian3.Main.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Batch8Ujian3.Main.Model.Bonus;
import com.Batch8Ujian3.Main.Model.BonusRowMapper;

@RestController
@RequestMapping("/bonus")
public class BonusController {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Bonus> getBonus() {
		
		String sql = "Select * from Bonus";
		
		List <Bonus> bonus = jdbc.query(sql,new BonusRowMapper());
		
		return bonus;
		
	}
	
	public int insertBonus(Bonus bonus) {
		
		return jdbc.update("insert into bonus(worker_ref_id, bonus_date, bonus_amount) values ('" + bonus.getWorker_Ref_Id() + 
				"','" + bonus.getBonus_Date() + "'," + bonus.getBonus_Amount() + ")");
		
	}
	
	public int updateBonus(String worker_ref_id, Bonus bonus) {

		return jdbc.update("update bonus set bonus_date ='" + bonus.getBonus_Date() + "', bonus_amount = " + bonus.getBonus_Amount() + 
				" where worker_ref_id = '" + bonus.getWorker_Ref_Id() + "'");

	}
	
	public int deleteBonus(String worker_ref_id) {
		
		return jdbc.update("delete from bonus where worker_ref_id = '" + worker_ref_id + "';");
	
	}
	
	@GetMapping("/")
	public List<Bonus> list(){
		
		return getBonus();
		
	}
	
	@PostMapping("/")
	public String add(@RequestBody Bonus bonus) {
		
		if(this.insertBonus(bonus) == 1) {
			return "Insert data bonus berhasil";
		}else {
			return "Insert data bonus gagal";
		}
		
	}
	
	@PutMapping("/{worker_ref_id}")
	public ResponseEntity<?> update(@RequestBody Bonus bonus, @PathVariable String worker_ref_id){
		
		try {
			updateBonus(worker_ref_id, bonus);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{worker_ref_id}")
	public void delete(@PathVariable String worker_ref_id) {
		
		deleteBonus(worker_ref_id);
		
	}
	
}
