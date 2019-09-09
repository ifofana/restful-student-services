package com.ia.restfulstudentservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "Audit_Trail")
public class AuditTrail {
	
	@Id
	@Column(name = "audit_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "created_on")
    private Date createdOn;
	
	@Column(name = "updated_on")
    private Date updatedOn;
	
	private Date auditTimestamp;
	
	private String auditActionRecord;
	
	public AuditTrail() {
	}

	public AuditTrail(Date auditTimestamp, String auditActionRecord) {
		this.createdOn = new Date();
		this.auditTimestamp = auditTimestamp;
		this.auditActionRecord = auditActionRecord;
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

	public Date getAuditTimestamp() {
		return auditTimestamp;
	}

	public void setAuditTimestamp(Date auditTimestamp) {
		this.auditTimestamp = auditTimestamp;
	}

	public String getAuditActionRecord() {
		return auditActionRecord;
	}

	public void setAuditActionRecord(String auditActionRecord) {
		this.auditActionRecord = auditActionRecord;
	}

}
