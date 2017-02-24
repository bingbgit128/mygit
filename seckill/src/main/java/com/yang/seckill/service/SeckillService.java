package com.yang.seckill.service;

import java.util.List;

import com.yang.seckill.entity.Seckill;

/**
 * 业务接口：站在使用者角度设计接口
 * 三个方面：方法粒度 参数 返回类型（return 类型/异常）
 * 
 * @author yang
 *
 */
public interface SeckillService {
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	/**
	 * 查询单个秒杀记录
	 * @param SeckillId
	 */
	Seckill getById( long SeckillId);
	/**
	 * 秒杀开启时输出秒杀接口地址
	 * 否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	void exportSeckillUrl(long seckillId);
}
