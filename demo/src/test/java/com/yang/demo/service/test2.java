package com.yang.demo.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yang.demo.dao.AccountDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/configs/spring/spring-applicationContext.xml"})
public class test2 {
	
	@Autowired
	public AccountService accountService;

	@Test
	public void demo(){
//		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/configs/spring/spring-applicationContext.xml");
//		accountService =  (AccountService) ac.getBean("accountService");
		accountService.transfer("aaa","bbb", new BigDecimal(200));
	}

}
