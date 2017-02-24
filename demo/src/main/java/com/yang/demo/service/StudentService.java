package com.yang.demo.service;

import org.springframework.stereotype.Service;

import com.yang.demo.entity.Student;

@Service
public interface StudentService {

	public String hello(String str);
	
	public Student getStudentById(Integer stuId);

}
