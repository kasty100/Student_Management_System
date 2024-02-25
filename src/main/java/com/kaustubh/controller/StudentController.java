package com.kaustubh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaustubh.entity.Student;
import com.kaustubh.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;



@RestController

public class StudentController {
	
	
	@Autowired
	StudentRepository repo;
	//get all the students 
	//localhost:8080/students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		 List<Student> students = repo.findAll();
		  return students;
	}
	//localhost:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudent (@PathVariable int id ) {
		Student student=  repo.findById(id).get();
		return student;
	}
	
	@PostMapping("/students/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
		
	}
	
	@PutMapping("/students/update/{id}")
	public Student updateStudents(@PathVariable int id) {
		//TODO: process PUT request
		Student student = repo.findById(id).get();
		student.setName("poonam");
		student.setPercentage(92);
		repo.save(student);
		
		return student;
		
		
	}
	@DeleteMapping("/students/delete/{id}")
	public Student deleteStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
		return student;
	}

}
