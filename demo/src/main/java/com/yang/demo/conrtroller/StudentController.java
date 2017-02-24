package com.yang.demo.conrtroller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.yang.demo.entity.Student;
import com.yang.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
//	rest风格
	@RequestMapping(value="/view/{stuId}",method=RequestMethod.GET)
	public String viewStudent(@PathVariable("stuId") Integer stuId, Map<String, Object> model) {
		Student student = studentService.getStudentById(stuId);
		model.put("student", student);
		return "home";
		
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String showUploadPage(){
		
		// 页面跳转
		return "file";
		
	}
	
	// 绑定
	@RequestMapping(value="/doUpload", method=RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request){
		
		
		if (!file.isEmpty()){
			try {
//				this.getClass().getClassLoader().getResource("/").getPath();
				System.out.println(request.getContextPath());
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File("../upload/",System.currentTimeMillis()+file.getOriginalFilename()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		// 页面跳转
		return "success";
		
	}
	
	
//	json  @res
	@RequestMapping(value="/json/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<Student> getStudentEntity(@PathVariable Integer id){
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student,HttpStatus.OK);
			
	}
}
