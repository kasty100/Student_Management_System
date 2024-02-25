package com.kaustubh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaustubh.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
