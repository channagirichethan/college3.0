package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entities.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {

	Teacher findByEmail(String email);

}
