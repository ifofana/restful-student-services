package com.ia.restfulstudentservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "PARENTGUARD_INFO")
public class ParentGuard {
	
	@Id
	@Column(name = "PG_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ParentGuard_Sequence")
	@SequenceGenerator(name = "ParentGuard_Sequence", sequenceName = "HIBERNATE_PARENTGUARD_SEQ", initialValue = 1)
	private Long id;
	
	@Column(name = "PG_NAME")
	private String name;
	
	@Column(name = "PG_ADDRESS_ONE")
	private String addressOne;
	
	@Column(name = "PG_ADDRESS_TWO")
	private String addresTwo;
	
	@Column(name = "PG_CITY")
	private String city;
	
	@Column(name = "PG_STATE")
	private String state;
	
	@Column(name = "PG_ZIPCODE")
	private String zipCode;
	
	@Column(name = "PG_PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "PG_ALT_PHONE_NUMBER")
	private String altPhoneNumber;
	
	@Column(name = "PG_EMAIL")
	private String email;
	
	@Column(name = "PG_ALT_EMAIL")
	private String altEmail;

	@OneToOne(mappedBy = "parentGuard")
	private Student student;
	
	public ParentGuard() {
	}

	public ParentGuard(String name, String addressOne, String addresTwo, String city, String state, String zipCode,
			String phoneNumber, String altPhoneNumber, String email, String altEmail, Student student) {
		this.name = name;
		this.addressOne = addressOne;
		this.addresTwo = addresTwo;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.altPhoneNumber = altPhoneNumber;
		this.email = email;
		this.altEmail = altEmail;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddresTwo() {
		return addresTwo;
	}

	public void setAddresTwo(String addresTwo) {
		this.addresTwo = addresTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAltPhoneNumber() {
		return altPhoneNumber;
	}

	public void setAltPhoneNumber(String altPhoneNumber) {
		this.altPhoneNumber = altPhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAltEmail() {
		return altEmail;
	}

	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}