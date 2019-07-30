package com.ia.restfulstudentservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "authorities", uniqueConstraints = @UniqueConstraint(columnNames = {"authority", "user_id"}))
public class UserRole {

	private String authority;
	private User user;

	public UserRole() {
		
	}
	
	public UserRole(String authority, User user) {
		this.authority = authority;
		this.user = user;
	}

	@Id
	@Column(name = "authority", nullable = false, unique = true, length = 45)
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
