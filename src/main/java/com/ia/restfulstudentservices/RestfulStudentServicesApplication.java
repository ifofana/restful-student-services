package com.ia.restfulstudentservices;

import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ia.restfulstudentservices.model.Course;
import com.ia.restfulstudentservices.model.Student;
import com.ia.restfulstudentservices.service.CourseService;

@SpringBootApplication
public class RestfulStudentServicesApplication implements CommandLineRunner {

	@Autowired
	CourseService courseService;

	public static void main(String[] args) {
		SpringApplication.run(RestfulStudentServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		setupNewCourse("Angular 7","Understanding Angular 7 in easy steps",null,null);
		setupNewCourse("Grafana","Grafana Demystified",null,null);
		setupNewCourse("Spring Boot","Spring Boot in 28 minutes",null,null);
		
		Student stud1 = new Student("Ibrahima", "Fofana", "ibrahima.fofana.ia@gmail.com");
		
		Student stud2 = new Student("Arona", "Dieme", "arona.dieme@luv2code.com");
		
		Student stud3 = new Student("Moustapha", "Sanogo", "m.sanogo@gmail.com");

	}

	private void setupNewCourse(String name, String desc, Date start, Date end) {
		Course newCourse = new Course();
		
		newCourse.setName(name);
		newCourse.setDescription(desc);
		
		// get a calendar instance, which defaults to "now"
		Calendar calendar = Calendar.getInstance();
		
		// get a date to represent "today"
		Date today = calendar.getTime();
		
		newCourse.setStartDate(today);
		
		// add one day to the date/calendar
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		
		// now get "tomorrow"
		Date tomorrow = calendar.getTime();
		
		newCourse.setEndDate(tomorrow);

		courseService.saveCourse(newCourse);
	}

}
