package com.spprogramming.restapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spprogramming.restapi.entity.Student;
import com.spprogramming.restapi.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repo;

	// get all students
	// localhost:1997/students
	@GetMapping("/students")
	public List<Student> getallStudents() {
		List<Student> students = repo.findAll();
		return students;

	}

	// localhost:1997/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
	}

	@PostMapping("/student/add")
	public void createStudent(@RequestBody Student student) {
		repo.save(student);

	}

	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setName("shubham");
		student.setPercentage(76);
		repo.save(student);
		return student;

	}

	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
	}

}
