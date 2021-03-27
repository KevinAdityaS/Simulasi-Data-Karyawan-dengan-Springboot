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

import com.Batch8Ujian3.Main.Model.Title;
import com.Batch8Ujian3.Main.Model.TitleRowMapper;

@RestController
@RequestMapping("/title")
public class TitleController {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Title> getTitle() {
		
		String sql = "Select * from Title";
		
		List <Title> title = jdbc.query(sql,new TitleRowMapper());
		
		return title;
		
	}
	
	public int insertTitle(Title title) {
		
		return jdbc.update("insert into title(worker_ref_id, worker_title, affected_from) values ('" + title.getWorker_Ref_Id() + 
				"','" + title.getWorker_Title() + "','" + title.getAffected_From() + "')");
		
	}
	
	public int updateTitle(String worker_ref_id, Title title) {

		return jdbc.update("update title set worker_title ='" + title.getWorker_Title() + "', affected_from = '" + title.getAffected_From() + 
				"' where worker_ref_id = '" + title.getWorker_Ref_Id() + "'");

	}
	
	public int deleteTitle(String worker_ref_id) {
		
		return jdbc.update("delete from title where worker_ref_id = '" + worker_ref_id + "';");
	
	}
	
	@GetMapping("/")
	public List<Title> list(){
		
		return getTitle();
		
	}
	
	@PostMapping("/")
	public String add(@RequestBody Title title) {
		
		if(this.insertTitle(title) == 1) {
			return "Insert data title berhasil";
		}else {
			return "Insert data title gagal";
		}
		
	}
	
	@PutMapping("/{worker_ref_id}")
	public ResponseEntity<?> update(@RequestBody Title title, @PathVariable String worker_ref_id){
		
		try {
			updateTitle(worker_ref_id, title);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{worker_ref_id}")
	public void delete(@PathVariable String worker_ref_id) {
		
		deleteTitle(worker_ref_id);
		
	}
	
}
