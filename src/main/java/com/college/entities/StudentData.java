package com.college.entities;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class StudentData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	 @Column(unique = true)
	String rollno;
	String name;
	String stream;
	 @ElementCollection
	 @JoinColumn
	    @CollectionTable(name = "test1_scores", joinColumns = @JoinColumn(name = "student_id"))
	    private Map<String, Integer> test1;

	    @ElementCollection
	    @CollectionTable(name = "test2_scores", joinColumns = @JoinColumn(name = "student_id"))
	    private Map<String, Integer> test2;

	    @ElementCollection
	    @CollectionTable(name = "exam1_scores", joinColumns = @JoinColumn(name = "student_id"))
	    private Map<String, Integer> exam1;

	    @ElementCollection
	    @CollectionTable(name = "exam2_scores", joinColumns = @JoinColumn(name = "student_id"))
	    private Map<String, Integer> exam2;
	int cls;
	String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getTest1() {
		return test1;
	}
	public void setTest1(Map<String, Integer> test1) {
		this.test1 = test1;
	}
	public Map<String, Integer> getTest2() {
		return test2;
	}
	public void setTest2(Map<String, Integer> test2) {
		this.test2 = test2;
	}
	public Map<String, Integer> getExam1() {
		return exam1;
	}
	public void setExam1(Map<String, Integer> exam1) {
		this.exam1 = exam1;
	}
	public Map<String, Integer> getExam2() {
		return exam2;
	}
	public void setExam2(Map<String, Integer> exam2) {
		this.exam2 = exam2;
	}
	public int getCls() {
		return cls;
	}
	public void setCls(int cls) {
		this.cls = cls;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public StudentData(Long id, String rollno, String name, Map<String, Integer> test1, Map<String, Integer> test2,
			Map<String, Integer> exam1, Map<String, Integer> exam2, int cls, String email) {
		super();
		this.id = id;
		this.rollno = rollno;
		this.name = name;
		this.test1 = test1;
		this.test2 = test2;
		this.exam1 = exam1;
		this.exam2 = exam2;
		this.cls = cls;
		this.email = email;
	}
	public StudentData() {
		super();
	}
	
	
	

}
