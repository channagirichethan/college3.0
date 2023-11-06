package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entities.Test;

public interface TestRepo extends JpaRepository<Test, Long>{

}
