package com.ia.restfulstudentservices.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "PARENTGUARD_INFO")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="parentId")
public class ParentGuard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parentId;
	
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
	
	@Column( name = "PG_RELATIONSHIP_TO_STUDENT")
	private String pgRelationshipToStudent;
	
	//bi-directional many-to-one association to Student
	@JoinColumn(updatable = false)
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonBackReference
    private Student student;
	
	public ParentGuard() {
	}
	
	public ParentGuard(String createdBy, String pgName, String pgAddressOne, String pgAddressTwo, String pgCity, String pgState, String pgZipCode, 
			String pgPhoneNumber, String pgAltPhoneNumber, String pgEmail, String pgAltEmail, String pgRelationshipToStudent, Student student) {
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
		this.student = student;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public String getPgRelationshipToStudent() {
		return pgRelationshipToStudent;
	}

	public void setPgRelationshipToStudent(String pgRelationshipToStudent) {
		this.pgRelationshipToStudent = pgRelationshipToStudent;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ParentGuard other = (ParentGuard) obj;
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
		builder.append("ParentGuard [parentId=");
		builder.append(parentId);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedOn=");
		builder.append(updatedOn);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", pgName=");
		builder.append(pgName);
		builder.append(", pgAddressOne=");
		builder.append(pgAddressOne);
		builder.append(", pgAddressTwo=");
		builder.append(pgAddressTwo);
		builder.append(", pgCity=");
		builder.append(pgCity);
		builder.append(", pgState=");
		builder.append(pgState);
		builder.append(", pgZipCode=");
		builder.append(pgZipCode);
		builder.append(", pgPhoneNumber=");
		builder.append(pgPhoneNumber);
		builder.append(", pgAltPhoneNumber=");
		builder.append(pgAltPhoneNumber);
		builder.append(", pgEmail=");
		builder.append(pgEmail);
		builder.append(", pgAltEmail=");
		builder.append(pgAltEmail);
		builder.append(", pgRelationshipToStudent=");
		builder.append("]");		
		return builder.toString();
	}
	
}
