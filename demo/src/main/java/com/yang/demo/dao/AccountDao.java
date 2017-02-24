package com.yang.demo.dao;

import java.math.BigDecimal;

public interface AccountDao {
		
		public void outMoney(String out,BigDecimal money);
		
		public void inMoney(String in,BigDecimal money);
}
