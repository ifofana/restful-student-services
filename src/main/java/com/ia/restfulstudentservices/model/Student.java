package com.ia.restfulstudentservices.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_INFO")
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_Sequence")
	@SequenceGenerator(name = "student_Sequence", sequenceName = "HIBERNATE_STUDENT_SEQ", initialValue = 1)
	private Long id;
	
	@Column(name = "STUDENT_FIRST_NAME")
	private String firstName;
	
	@Column(name = "STUDENT_MIDDLE_NAME")
	private String middlename;
	
	@Column(name = "STUDENT_LAST_NAME")
	private String lastName;
	
	@Column(name = "STUDENT_DOB")
	private Date dob;
	
	@Column(name = "STUDENT_AGE")
	private int age;
	
	@Column(name = "STUDENT_GENDER")
	private String gender;
	
	@Column(name = "STUDENT_ALLERGES_MEDICAL_CONDITION")
	private String allerges;
	
	@Column(name = "STUDENT_CLASS_SELECTION")
	private String classSelection;
	
	@Column(name = "STUDENT_CLASSL_DAY")
	private String classDay;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_RELATIONSHIP_TO_STUDENT", referencedColumnName = "CONTACT_ID")
	private Contact contact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PG_RELATIONSHIP_TO_STUDENT", referencedColumnName = "PG_ID")
	private ParentGuard parentGuard;
	
    public Student() {
        
    }

	public Student(String firstName, String middlename, String lastName, Date dob, int age, String gender,
			String allerges, String classSelection, String classDay, Contact contact) {
		this.firstName = firstName;
		this.middlename = middlename;
		this.lastName = lastName;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.allerges = allerges;
		this.classSelection = classSelection;
		this.classDay = classDay;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAllerges() {
		return allerges;
	}

	public void setAllerges(String allerges) {
		this.allerges = allerges;
	}

	public String getClassSelection() {
		return classSelection;
	}

	public void setClassSelection(String classSelection) {
		this.classSelection = classSelection;
	}

	public String getClassDay() {
		return classDay;
	}

	public void setClassDay(String classDay) {
		this.classDay = classDay;
	}

	public Contact getContactInfo() {
		return contact;
	}

	public void setContactInfo(Contact contact) {
		this.contact = contact;
	}
	

}
