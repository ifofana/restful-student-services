package com.ia.restfulstudentservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.NonNull;

import javax.persistence.Id;

@Entity
@Table(name = "EMERGENCY_CONTACT_INFO")
public class ContactInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @NonNull Long id;

	public ContactInfo() {
	}
}
