package com.spprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spprogramming.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
