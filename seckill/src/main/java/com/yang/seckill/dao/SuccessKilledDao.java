package com.yang.seckill.dao;

import com.yang.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
	/**
	 * 插入购买明细，过滤重复
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessKilled(long seckillId,long userPhone);
	/**
	 * 根据id查询successKilled并秒杀产品对象实体
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(long seckillId);
}
