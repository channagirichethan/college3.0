package com.college.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher {
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	 @Column(unique = true)
	String email;
	String password;
	String subject;
	
	public Teacher() {
		super();
	}
	public Teacher(Long id, String name, String email, String password, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.subject = subject;
	}
	
	public Teacher( String name, String email, String password, String subject) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.subject = subject;
	}
	
	
	
}
