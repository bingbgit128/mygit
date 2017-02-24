package com.yang.demo.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yang.demo.entity.Grade;
import com.yang.demo.entity.Student;
import com.yang.demo.entity.Teacher;

public class StudentTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init(){
		
		// 创建配置对象
		Configuration configuration = new Configuration().configure();
		// 创建 服务注册对象
		@SuppressWarnings("deprecation")
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		// 创建回话工厂对象
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		// 创建会话对象
//		session = sessionFactory.openSession();
		// 创建session对象
//		session= sessionFactory.getCurrentSession();
		// 开始事物
//		transaction = session.beginTransaction();
		
		
	}
	
	@After
	public void destory() {
		transaction.commit(); //
		 session.close(); //getCurrentSession 自动关闭 session
		sessionFactory.close();
	}
	
	
	@Test
	public void cache(){
		// 创建session对象
		session = sessionFactory.openSession();
				transaction = session.beginTransaction();
		Teacher teacher = (Teacher) session.get(Teacher.class, 1);
		System.out.println(teacher.gettName());
		
		// 创建session对象
		session = sessionFactory.openSession();
		 teacher = (Teacher) session.get(Teacher.class, 1);
		System.out.println(teacher.gettName());
		
	}
	
	
	
	
	
	
	@Test
	public void testQueryToList(){
		String hql = "select new list(t.tId,t.tName,t.tAge) from Teacher t";
		Query query = session.createQuery(hql);
		List<List> lists = query.list();
		for(List list: lists){
			System.out.println("name="+list.get(1));
			System.out.println("age="+list.get(2));
		}	
	}
	
	
	
	
	@Test
	public void testQuery(){
		String hql = "from Teacher";
		String hql2 = "from Teacher";
		Query query = session.createQuery(hql);
		List<Teacher> teachers = query.list();
		 for(Teacher t: teachers){

			Iterator<Student> it = t.gettStudent().iterator();
			while(it.hasNext()){
				Student str = it.next();
//				System.out.println(str.getName());
					
			}
		 }
		
	}
	
	
	@Test
	public void testTeacher(){
		Student student = new Student("张三","123");
		
		Student student2 = new Student("李四","123");
				
		Teacher teacher1 = new Teacher("t1","20");
		
		Teacher teacher2 = new Teacher("t2","24");
		
		student.getsTeacher().add(teacher1);
		student.getsTeacher().add(teacher2);
		
//		student2.getsTeacher().add(teacher1);
		
		
		
		
//		teacher1.gettStudent().add(student);
//		teacher1.gettStudent().add(student2);
		
		
		
		
		
		
		session.save(student);
		
				
		
	}
	
	
	@Test
	public void testSerach(){
		Student student = (Student) session.get(Student.class, 6);
		System.out.println(student.getGrade());
		
	}
	
	@Test
	public void testSaveStudents(){
		Grade grade = new Grade("java3","dfs");
		Student student = new Student("张三","123");
		Student student2 = new Student("李四","123");
		
//		设置关联关系  多对一
		student.setGrade(grade);
		student2.setGrade(grade);
		
		
		grade.getStudents().add(student); // 一对多
		grade.getStudents().add(student2);
		
		
		session.save(grade); 
//		session.save(student); //保存对象
//		session.save(student2);
	}
	
	@Test
	public void testUpateStudents(){
		Grade grade = new Grade("java3","dffsg");
		
		Student student = (Student) session.get(Student.class, 3);
		
		grade.getStudents().add(student);
		session.save(grade);
		
//		System.out.println(student.getName());
	}
	
	@Test
	public void testDelete(){
		Student student = (Student) session.get(Student.class, 3);
		session.delete(student);
		
	}
	
}
