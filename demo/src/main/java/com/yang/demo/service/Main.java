package com.yang.demo.service;

import com.yang.demo.service.impl.StudentServiceImpl;

public class Main {

	public static void main(String[] args) {
		StudentService st = new StudentServiceImpl();
		System.out.println(st.hello("weird"));
	}

}
