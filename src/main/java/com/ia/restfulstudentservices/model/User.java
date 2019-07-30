package com.ia.restfulstudentservices.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	
	private Long id;
	private String username;
	private String password;
	private boolean enabled;
	private Set<UserRole> authorities = new HashSet<UserRole>();
	
	public User() {
	
	}
	
	public User(Long id, String username, String password, boolean enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(Long id, String username, String password, 
			boolean enabled, Set<UserRole> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_Sequence")
	@SequenceGenerator(name = "users_Sequence", sequenceName = "USERS_SEQ", initialValue = 4)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<UserRole> authorities) {
		this.authorities = authorities;
	}
	
}
