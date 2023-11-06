package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

}
