package com.yang.demo.service;

import java.math.BigDecimal;

/**
 * 转账借口
 */
public interface AccountService {
	public void transfer(String out,String in, BigDecimal money);
	
}
