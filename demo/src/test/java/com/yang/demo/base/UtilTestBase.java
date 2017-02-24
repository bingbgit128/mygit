package com.yang.demo.base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class UtilTestBase {
	
	private ClassPathXmlApplicationContext context;
	private String springXmlPath;
	public UtilTestBase() {
	}
	
	UtilTestBase(String springXmlPath){
		this.springXmlPath = springXmlPath;
		
	}
	
	@Before
	public void before(){
		
		if(StringUtils.isEmpty(springXmlPath)){
			springXmlPath = "classpath*:spring-*.xml";
		}
		
		try{
			context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
			context.start();
		} catch (BeansException e){
			e.printStackTrace();
		}
	}
	
	@After
	public void after(){
		context.destroy();
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends Object> T getBean(String beanId){
		return (T)context.getBean(beanId);
	}

	protected <T extends Object> T getBean(Class<T> clazz){
		return context.getBean(clazz);
	}
	
	

}
