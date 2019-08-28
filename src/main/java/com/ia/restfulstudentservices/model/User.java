package com.ia.restfulstudentservices.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6147614719923616174L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private @NonNull Long id;
	
	
	@Column(name = "name")
	private @NonNull String name;
	
	@Column(name = "username")
	private @NonNull String username;
	
	@Column(name = "password")
	private @NonNull String password;
	
	@Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;
	
	@Transient
    private String token;
	
}
