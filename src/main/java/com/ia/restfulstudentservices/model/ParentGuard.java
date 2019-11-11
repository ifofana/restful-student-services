package com.ia.restfulstudentservices.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name = "PARENTGUARD_INFO")
public class ParentGuard {
	
	@Id
	@Column(name = "PG_ID")
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
	
	@Column(name = "PG_NAME")
	private String pgName;
	
	@Column(name = "PG_ADDRESS_ONE")
	private String pgAddressOne;
	
	@Column(name = "PG_ADDRESS_TWO")
	private String pgAddressTwo;
	
	@Column(name = "PG_CITY")
	private String pgCity;
	
	@Column(name = "PG_STATE")
	private String pgState;
	
	@Column(name = "PG_ZIPCODE")
	private String pgZipCode;
	
	@Column(name = "PG_PHONE_NUMBER")
	private String pgPhoneNumber;
	
	@Column(name = "PG_ALT_PHONE_NUMBER")
	private String pgAltPhoneNumber;
	
	@Column(name = "PG_EMAIL")
	private String pgEmail;
	
	@Column(name = "PG_ALT_EMAIL")
	private String pgAltEmail;
	
	@OneToMany(mappedBy="parentGuard")
	@JsonIgnore
    private Set<Student> students;
	
	@Column( name = "PG_RELATIONSHIP_TO_STUDENT")
	private String pgRelationshipToStudent;
	
	public ParentGuard() {
	}
	
	public ParentGuard(String createdBy, String pgName, String pgAddressOne, String pgAddressTwo, String pgCity, String pgState, String pgZipCode, 
			String pgPhoneNumber, String pgAltPhoneNumber, String pgEmail, String pgAltEmail, String pgRelationshipToStudent) {
		this.createdOn = new Date();
		this.createdBy = createdBy;
		this.pgName = pgName;
		this.pgAddressOne = pgAddressOne;
		this.pgAddressTwo = pgAddressTwo;
		this.pgCity = pgCity;
		this.pgState = pgState;
		this.pgZipCode = pgZipCode;
		this.pgPhoneNumber = pgPhoneNumber;
		this.pgAltPhoneNumber = pgAltPhoneNumber;
		this.pgEmail = pgEmail;
		this.pgAltEmail = pgAltEmail;
		this.pgRelationshipToStudent = pgRelationshipToStudent;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPgName() {
		return pgName;
	}

	public void setPgName(String pgName) {
		this.pgName = pgName;
	}
	
	public String getPgAddressOne() {
		return pgAddressOne;
	}

	public void setPgAddressOne(String pgAddressOne) {
		this.pgAddressOne = pgAddressOne;
	}
	
	public String getPgAddressTwo() {
		return pgAddressTwo;
	}

	public void setPgAddressTwo(String pgAddressTwo) {
		this.pgAddressTwo = pgAddressTwo;
	}
	
	public String getPgCity() {
		return pgCity;
	}

	public void setPgCity(String pgCity) {
		this.pgCity = pgCity;
	}
	
	public String getPgState() {
		return pgState;
	}

	public void setPgState(String pgState) {
		this.pgState = pgState;
	}
	
	public String getPgZipCode() {
		return pgZipCode;
	}

	public void setPgZipCode(String pgZipCode) {
		this.pgZipCode = pgZipCode;
	}
	
	public String getPgPhoneNumber() {
		return pgPhoneNumber;
	}

	public void setPgPhoneNumber(String pgPhoneNumber) {
		this.pgPhoneNumber = pgPhoneNumber;
	}
	
	public String getPgAltPhoneNumber() {
		return pgAltPhoneNumber;
	}

	public void setPgAltPhoneNumber(String pgAltPhoneNumber) {
		this.pgAltPhoneNumber = pgAltPhoneNumber;
	}

	public String getPgEmail() {
		return pgEmail;
	}

	public void setPgEmail(String pgEmail) {
		this.pgEmail = pgEmail;
	}
	
	public String getPgAltEmail() {
		return pgAltEmail;
	}

	public void setPgAltEmail(String pgAltEmail) {
		this.pgAltEmail = pgAltEmail;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public String getPgRelationshipToStudent() {
		return pgRelationshipToStudent;
	}

	public void setPgRelationshipToStudent(String pgRelationshipToStudent) {
		this.pgRelationshipToStudent = pgRelationshipToStudent;
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
		ParentGuard other = (ParentGuard) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
