package com.briup.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.MyBatisSqlSessionFactory;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.dao.ICustomerDao;
import com.briup.estore.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{
	
	private ICustomerDao dao;
	
	@Override
	public void register(Customer customer) throws CustomerException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		dao = session.getMapper(ICustomerDao.class);
		
		try {
			if(dao.findByName(customer.getName())==null){
				dao.saveCustomer(customer);
			}else{
				throw new CustomerException("用户名已经存在了");
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			throw new CustomerException(e.getMessage());
		}
		
	}

	@Override
	public Customer login(String name, String password) throws CustomerException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		dao = session.getMapper(ICustomerDao.class);
		
		Customer customer = dao.findByName(name);
		if(customer==null){
			throw new CustomerException("该用户名不存在");
		}
		else if(!customer.getPassword().equals(password)){
			throw new CustomerException("密码不正确");
		}
		else{
			return customer;
		}
		
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		dao = session.getMapper(ICustomerDao.class);
		
		try {
			dao.updateCustomer(customer);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			throw new CustomerException(e.getMessage());
		}
	}

}
