/*
 * Filename: Contact.java
 * author: Jimmy Maher
 * Date: 06 Sept 2019
 * Purpose: Map contact class to the contact table in dbusermanagement 
 */

package com.ia.restfulstudentservices.model;

// import date class from java.util package
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "CONTACT_INFO")
public class Contact {
	
	@Id
	@Column(name = "CONTACT_ID")
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
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "CONTACT_PHONE_NUMBER")
	private String contactPhoneNumber;
	
	@Column(name = "CONTACT_ALT_PHONE_NUMBER")
	private String contactAltPhoneNumber;
	
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name = "CONTACT_ALT_EMAIL")
	private String contactAltEmail;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="contact", cascade = CascadeType.ALL)
	// @JsonIgnore
    private Set<Student> students;
	
	@Column(name = "CONTACT_RELATIONSHIP_TO_STUDENT")
	private String contactRelationshipToStudent;

	public Contact() {
	}
	
	public Contact(String createdBy, String contactName, String contactPhoneNumber, String contactAltPhoneNumber, String contactEmail,
			String contactAltEmail, String contactRelationshipToStudent, Set<Student> students) {
		this.createdOn = new Date();
		this.createdBy = createdBy;
		this.contactName = contactName;
		this.contactPhoneNumber = contactPhoneNumber;
		this.contactAltPhoneNumber = contactAltPhoneNumber;
		this.contactEmail = contactEmail;
		this.contactAltEmail = contactAltEmail;
		this.contactRelationshipToStudent = contactRelationshipToStudent;
		this.students = students;
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

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getContactAltPhoneNumber() {
		return contactAltPhoneNumber;
	}

	public void setContactAltPhoneNumber(String contactAltPhoneNumber) {
		this.contactAltPhoneNumber = contactAltPhoneNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactAltEmail() {
		return contactAltEmail;
	}

	public void setContactAltEmail(String contactAltEmail) {
		this.contactAltEmail = contactAltEmail;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public String getContactRelationshipToStudent() {
		return contactRelationshipToStudent;
	}

	public void setContactRelationshipToStudent(String contactRelationshipToStudent) {
		this.contactRelationshipToStudent = contactRelationshipToStudent;
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
		Contact other = (Contact) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [id=");
		builder.append(id);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedOn=");
		builder.append(updatedOn);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", contactName=");
		builder.append(contactName);
		builder.append(", contactPhoneNumber=");
		builder.append(contactPhoneNumber);
		builder.append(", contactAltPhoneNumber=");
		builder.append(contactAltPhoneNumber);
		builder.append(", contactEmail=");
		builder.append(contactEmail);
		builder.append(", contactAltEmail=");
		builder.append(contactAltEmail);
		builder.append(", contactRelationshipToStudent=");
		builder.append(contactRelationshipToStudent);
		builder.append(",students=");
		builder.append(students);
		builder.append("]");		
		return builder.toString();
	}
	
}
