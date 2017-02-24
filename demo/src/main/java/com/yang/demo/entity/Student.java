package com.yang.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sId;
	private String name;
	private String age;
	
	private Grade grade;
	
	private Set<Teacher> sTeacher = new HashSet<Teacher>();
	

	
	public Student(Integer sId, String name, String age, Grade grade, Set<Teacher> sTeacher) {
		super();
		this.sId = sId;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.sTeacher = sTeacher;
	}
	public Set<Teacher> getsTeacher() {
		return sTeacher;
	}
	public void setsTeacher(Set<Teacher> sTeacher) {
		this.sTeacher = sTeacher;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Student( String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + ", age=" + age + "]";
	}
	public Student() {
		super();
	}
	
	
}
