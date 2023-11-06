package com.college.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String email;

	Integer standard;
	String name;
	String rollno;
//	
//	List<String> subjects;
//	@OneToMany
//	List<Test> tests;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public Integer getStandard() {
//		return standard;
//	}
//	public void setStandard(Integer standard) {
//		this.standard = standard;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getRollno() {
//		return rollno;
//	}
//	public void setRollno(String rollno) {
//		this.rollno = rollno;
//	}
//	public List<String> getSubjects() {
//		return subjects;
//	}
//	public void setSubjects(List<String> subjects) {
//		this.subjects = subjects;
//	}
//	public List<Test> getTests() {
//		return tests;
//	}
//	public void setTests(Test test) {
//		this.tests.add(test);
//	}

}
