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

import com.ia.restfulstudentservices.model.Course;
import com.ia.restfulstudentservices.model.Student;
import com.ia.restfulstudentservices.service.CourseService;
import com.ia.restfulstudentservices.service.StudentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@GetMapping(path = "/training/students")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping(path = "/training/students/{id}")
	public Student getStudent(@PathVariable Long id)
	{
		return studentService.findById(id);
	}
		
	@DeleteMapping(path = "/training/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
	{
		studentService.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping(path = "/training/students/{courseId}")
	public ResponseEntity<Void> createStudent(@PathVariable Long courseId, @RequestBody Student student){
		
		Course aCourse = courseService.findById(courseId);
		
		student.setCourse(aCourse);
		
		Student studentCreated = studentService.saveStudent(student);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studentCreated.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path = "/training/students/{id}/courses/{courseId}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @PathVariable long courseId, @RequestBody Student student) {
		
		Course aCourse = courseService.findById(courseId);
		
		student.setCourse(aCourse);
		
		Student studentUpdated = studentService.saveStudent(student);
		
		return new ResponseEntity<Student>(studentUpdated, HttpStatus.OK);
	}
	
	

}
