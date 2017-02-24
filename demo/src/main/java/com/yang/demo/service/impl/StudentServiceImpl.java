package com.yang.demo.service.impl;

import org.springframework.stereotype.Service;

import com.yang.demo.entity.Student;
import com.yang.demo.service.StudentService;

@Service("sutdentService")
public class StudentServiceImpl implements StudentService {

	public String hello(String str) {
		
		return "interface"+ str;
		
	}

	@Override
	public Student getStudentById(Integer StuId) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setsId(StuId);
		student.setAge("123");
		student.setName("张三");
		student.setsId(StuId);
		student.setAge("12433");
		student.setName("张三额外若无");
		System.out.println("student---"+student);
		return student;
	}

}
