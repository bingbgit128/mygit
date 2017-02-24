package com.yang.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yang.seckill.entity.Seckill;

public interface SeckillDao {
	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	public int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);
	
	
	Seckill queryById(long seckillId);
	
	List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}
