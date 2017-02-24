package com.yang.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Grade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int gId;
	private String gName;
	private String gDesc;
	
//	一对多
	private Set<Student> students = new HashSet<>();


	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgDesc() {
		return gDesc;
	}

	public void setgDesc(String gDesc) {
		this.gDesc = gDesc;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Grade(String gName, String gDesc) {
		super();
		this.gName = gName;
		this.gDesc = gDesc;
	}

	public Grade() {
		super();
	}

	@Override
	public String toString() {
		return "Grade [gId=" + gId + ", gName=" + gName + ", gDesc=" + gDesc + ", students=" + students + "]";
	}

	public Grade(int gId, String gName, String gDesc, Set<Student> students) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gDesc = gDesc;
		this.students = students;
	}
	
	
	
}
