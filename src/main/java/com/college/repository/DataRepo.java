package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.entities.Student;
import com.college.entities.StudentData;

@Repository
public interface DataRepo extends JpaRepository<StudentData, Long> {

	List<StudentData> findByCls(int parseInt);


	StudentData findByrollno(String rollno);

}
