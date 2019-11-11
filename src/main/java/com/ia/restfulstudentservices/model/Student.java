package com.ia.restfulstudentservices.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "STUDENT_INFO")
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "created_on")
    private Date createdOn;
	
	@Column(name = "created_by")
    private String createdBy;
	
	@Column(name = "updated_on")
    private Date updatedOn;
	
	@Column(name = "updated_by")
    private String updatedBy;
	
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
	
	@Column(name = "STUDENT_CLASS_DAY")
	private String classDay;
	
	@ManyToOne
    @JoinColumn(name="CONTACT_ID", nullable=false)
	private Contact contact;
	
	@ManyToOne
    @JoinColumn(name="PARENTGUARD_ID", nullable=false)
    private ParentGuard parentGuard;
	
    public Student() {
        
    }
    
    public Student(String createdBy, String firstName, String middlename, String lastName, Date dob, int age, String gender,
			String allerges, String classSelection, String classDay) {
		this.createdOn = new Date();
		this.createdBy = createdBy;
		this.firstName = firstName;
		this.middlename = middlename;
		this.lastName = lastName;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.allerges = allerges;
		this.classSelection = classSelection;
		this.classDay = classDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ParentGuard getParentGuard() {
		return parentGuard;
	}

	public void setParentGuard(ParentGuard parentGuard) {
		this.parentGuard = parentGuard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
