package com.yang.demo.service.impl;

import java.math.BigDecimal;

import org.springframework.transaction.annotation.Transactional;

import com.yang.demo.dao.AccountDao;
import com.yang.demo.service.AccountService;

@Transactional
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	
	public void transfer(String out, String in, BigDecimal money) {
		
		accountDao.outMoney(out, money);
//		int i = 2/0;
		accountDao.inMoney(in, money);

	}


}
