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

import com.Batch8Ujian3.Main.Model.DeptInfo;
import com.Batch8Ujian3.Main.Model.DeptInfoRowMapper;
import com.Batch8Ujian3.Main.Model.Worker;
import com.Batch8Ujian3.Main.Model.WorkerRowMapper;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Worker> getWorker() {
		
		String sql = "Select * from Worker";
		
		List <Worker> worker = jdbc.query(sql,new WorkerRowMapper());
		
		return worker;
		
	}
	
	public int insertWorker(Worker worker) {
		
		return jdbc.update("insert into worker(worker_id, first_name, last_name, salary, joining_date, departement) values ('" + worker.getWorker_Id() + "','" + worker.getFirst_Name() + 
				"','" + worker.getLast_Name() + "'," + worker.getSalary() + ",'" + worker.getJoining_Date() + "','" + worker.getDepartement() + "')");
		
	}
	
	public int updateWorker(String worker_id, Worker worker) {

		return jdbc.update("update worker set first_name ='" + worker.getFirst_Name() + "', last_name = '" + worker.getLast_Name() + "', salary =" + worker.getSalary() + 
				", joining_date ='" + worker.getJoining_Date() + "', departement ='" + worker.getDepartement() + "' where worker_id = '" + worker.getWorker_Id() + "'");

	}
	
	public int deleteWorker(String worker_id) {
		
		return jdbc.update("delete from worker where worker_id = '" + worker_id + "';");
	
	}
	
	public List<Worker> getWorkerHighestSalary() {
		
		String sql = "select * from worker order by Salary desc limit 5";
		
		List <Worker> worker = jdbc.query(sql,new WorkerRowMapper());
		
		return worker;
		
	}
	
	public List<Worker> getWorkerIdenticSalary() {
		
		String sql = "Select * from worker where Salary in (select Salary from worker group by Salary having ( count(Salary) > 1 ))";
		
		List <Worker> worker = jdbc.query(sql,new WorkerRowMapper());
		
		return worker;
		
	}
	
	public List<DeptInfo> getDeptInfo() {
		
		String sql = "CALL Number_Of_Workers()";
		
		List <DeptInfo> deptinfo = jdbc.query(sql,new DeptInfoRowMapper());
		
		return deptinfo;
		
	}
	
	@GetMapping("/")
	public List<Worker> list(){
		
		return getWorker();
		
	}
	
	@PostMapping("/")
	public String add(@RequestBody Worker worker) {
		
		if(this.insertWorker(worker) == 1) {
			return "Insert data worker berhasil";
		}else {
			return "Insert data worker gagal";
		}
		
	}
	
	@PutMapping("/{worker_id}")
	public ResponseEntity<?> update(@RequestBody Worker worker, @PathVariable String worker_id){
		
		try {
			updateWorker(worker_id, worker);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{worker_id}")
	public void delete(@PathVariable String worker_id) {
		
		deleteWorker(worker_id);
		
	}
	
	@GetMapping("/highestsal")
	public List<Worker> listHighestSal(){
		
		return getWorkerHighestSalary();
		
	}
	
	@GetMapping("/identicsal")
	public List<Worker> listIdenticSal(){
		
		return getWorkerIdenticSalary();
		
	}
	
	@GetMapping("/deptinfo")
	public List<DeptInfo> listDept(){
		
		return getDeptInfo();
		
	}
	
}
