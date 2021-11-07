package com.ia.restfulstudentservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ia.restfulstudentservices.model.Student;
import com.ia.restfulstudentservices.repository.StudentRepository;
import com.ia.restfulstudentservices.service.StudentService;

/**
 * 
 * @author ibrah
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping(path = "/api/students")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping(path = "/api/students/{id}")
	public Student getStudent(@PathVariable Long id)
	{
		return studentService.findById(id);
	}
		
	@DeleteMapping(path = "/api/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
	{
		studentService.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping(path = "/api/students")
	public ResponseEntity<Void> createStudent(@RequestBody Student student){
		
		Student studentCreated = studentService.saveStudent(student);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studentCreated.getStudentId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path = "/api/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student) {
		
		Student studentUpdated = studentService.saveStudent(student);
		
		return new ResponseEntity<Student>(studentUpdated, HttpStatus.OK);
	}

}
