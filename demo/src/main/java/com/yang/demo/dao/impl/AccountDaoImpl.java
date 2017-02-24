package com.yang.demo.dao.impl;

import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.yang.demo.dao.AccountDao;

public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao {
	

	@SuppressWarnings("unchecked")
	@Override
	public void outMoney(String out, BigDecimal money) {
		String sql = "update account a set a.money = a.money-? where a.name = ?";
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter(0,money);
				query.setParameter(1, out);
				return query.executeUpdate();
			}
			
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public void inMoney(String in, BigDecimal money) {
		String sql = "update account a set a.money = a.money+? where a.name = ?";
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter(0, money);
				query.setParameter(1, in);
				return query.executeUpdate();
			}
			
		});
	}
}
