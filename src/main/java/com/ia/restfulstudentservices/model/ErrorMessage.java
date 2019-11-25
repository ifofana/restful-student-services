package com.ia.restfulstudentservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "Error_Message")
public class ErrorMessage {
	
	@Id
	@Column(name = "error_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "created_on")
    private Date createdOn;
	
	@Column(name = "updated_on")
    private Date updatedOn;
		
	private String errorDescription;
	
	private int errorMessageNumber;
	
	public ErrorMessage() {
	}

	public ErrorMessage(String errorDescription, int errorMessageNumber) {
		this.createdOn = new Date();
		this.errorDescription = errorDescription;
		this.errorMessageNumber = errorMessageNumber;
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

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public int getErrorMessageNumber() {
		return errorMessageNumber;
	}

	public void setErrorMessageNumber(int errorMessageNumber) {
		this.errorMessageNumber = errorMessageNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorMessage [id=");
		builder.append(id);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", updatedOn=");
		builder.append(updatedOn);
		builder.append(", errorDescription=");
		builder.append(errorDescription);
		builder.append(", errorMessageNumber=");
		builder.append(errorMessageNumber);
		builder.append("]");
		return builder.toString();
	}

}
