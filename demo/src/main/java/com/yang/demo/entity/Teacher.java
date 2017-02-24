package com.yang.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements Serializable {
	
		private Integer tId;
		private String tName;
		private String tAge;
		private Set<Student> tStudent = new HashSet<Student>();
		public Integer gettId() {
			return tId;
		}
		public void settId(Integer tId) {
			this.tId = tId;
		}
		public String gettName() {
			return tName;
		}
		public void settName(String tName) {
			this.tName = tName;
		}
		public String gettAge() {
			return tAge;
		}
		public void settAge(String tAge) {
			this.tAge = tAge;
		}
		public Set<Student> gettStudent() {
			return tStudent;
		}
		public void settStudent(Set<Student> tStudent) {
			this.tStudent = tStudent;
		}
		public Teacher() {
			super();
		}
		public Teacher(Integer tId, String tName, String tAge, Set<Student> tStudent) {
			super();
			this.tId = tId;
			this.tName = tName;
			this.tAge = tAge;
			this.tStudent = tStudent;
		}
		public Teacher(String tName, String tAge) {
			super();
			this.tName = tName;
			this.tAge = tAge;
		}
		
		
		
}
