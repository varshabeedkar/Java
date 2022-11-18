package mongodbexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mongodbexample.models.Student;
import mongodbexample.repo.StudentRepository;

@RestController
@RequestMapping("/student")
public class MongoController {
	
	@Autowired
	private StudentRepository repository;

	@PostMapping("/")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		Student save=this.repository.save(student);
		return ResponseEntity.ok(save);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudent(){
		
		return ResponseEntity.ok(this.repository.findAll());
		
	}
}
