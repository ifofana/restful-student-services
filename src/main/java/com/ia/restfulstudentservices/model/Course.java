package com.ia.restfulstudentservices.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_Sequence")
	@SequenceGenerator(name = "course_Sequence", sequenceName = "COURSE_SEQ", initialValue = 1)
	private @NonNull Long id;
	
	private @NonNull String name;
	
	private String description;
	
	private @NonNull Date startDate;
	
	private @NonNull Date endDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "course")
	@JsonIgnore
	private List<Student> students;
	
}
