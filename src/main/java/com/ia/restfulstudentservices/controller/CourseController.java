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
import com.ia.restfulstudentservices.service.CourseService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping(path = "/api/courses")
	public List<Course> getAllCourses()
	{
		return courseService.getAllCourses();
	}
	
	@GetMapping(path = "/api/courses/{id}")
	public Course getCourse(@PathVariable Long id)
	{
		return courseService.findById(id);
	}
		
	@DeleteMapping(path = "/api/courses/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id)
	{
		courseService.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping(path = "/api/courses")
	public ResponseEntity<Void> createCourse(@RequestBody Course course){
		Course createdCourse = courseService.saveCourse(course);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path = "/api/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody Course course) {
		
		Course courseUpdated = courseService.saveCourse(course);
		
		return new ResponseEntity<Course>(courseUpdated, HttpStatus.OK);
	}

}
