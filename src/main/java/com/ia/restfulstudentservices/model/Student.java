package com.ia.restfulstudentservices.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "STUDENT_INFO")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="studentId")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STUDENT_ID")
	private Long studentId;
	
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
	
	//bi-directional many-to-one association to Contact
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonBackReference
	private Contact contact;
	
	private Long contactId;
	
	//bi-directional one-to-many association to ParentGuard
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student", fetch = FetchType.LAZY)
	@JsonManagedReference
    private Set<ParentGuard> parentGuardians;
	
    public Student() {
        
    }
    
    public Student(String createdBy, String firstName, String middlename, String lastName, Date dob, int age, String gender,
			String allerges, String classSelection, String classDay, Contact contact, Set<ParentGuard> parentGuardians) {
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
		this.contact = contact;
		this.parentGuardians = parentGuardians;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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
	
	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public Set<ParentGuard> getParentGuardians() {
		return parentGuardians;
	}

	public void setParentGuardians(Set<ParentGuard> parentGuardians) {
		this.parentGuardians = parentGuardians;
	}
	
	public ParentGuard addParentGuard(ParentGuard parentGuard) {
		getParentGuardians().add(parentGuard);
		parentGuard.setStudent(this);
		
		return parentGuard;
	}
	
	public ParentGuard removeParentGuard(ParentGuard parentGuard) {
		getParentGuardians().remove(parentGuard);
		parentGuard.setStudent(null);
		
		return parentGuard;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [studentId=");
		builder.append(studentId);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedOn=");
		builder.append(updatedOn);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", middlename=");
		builder.append(middlename);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", age=");
		builder.append(age);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", allerges=");
		builder.append(allerges);
		builder.append(", classSelection=");
		builder.append(classSelection);
		builder.append(", classDay=");
		builder.append(classDay);
		builder.append(", parentGuards=");
		builder.append(parentGuardians);
		builder.append("]");		
		return builder.toString();
	}

}
