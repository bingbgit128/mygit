package com.yang.seckill.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yang.seckill.entity.Seckill;

//配置Spring junit 整合   启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:configs/spring/spring-Dao.xml")
public class SeckillDaoTest {
//	注入Dao实现类的依赖

	private SeckillDao seckillDao;

	@Test
	public void testReduceNumber() throws Exception {
		
//		id
		int count = seckillDao.reduceNumber(1000L, new Date());
		System.out.println("count="+count);
	}

	@Test
	/**
	 * 
	 */
	public void testQueryById() throws Exception {

		Long id = (long) 1002;
		Seckill seckill =  seckillDao.queryById(id);
		System.out.println("seckillName="+seckill.getName());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(seckill.getCreateTime()) );
		
	}

	@Test
	/**
	 * 当有多个参数时 需要 添加注解 @Param()
	 * @throws Exception
	 */
	public void testQueryAll() throws Exception {
		List<Seckill> seckill =  seckillDao.queryAll(0, 100);
		for(Seckill s:seckill){
				System.out.println(s.getName());
				
		}
	}

}
