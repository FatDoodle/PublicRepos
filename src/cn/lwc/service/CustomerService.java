package cn.lwc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lwc.entity.Customer;

public interface CustomerService {

	void saveCust(Customer customer);


	List<Customer> findCustList();




	void deleteByObject(Customer customer);


	Customer findCustByObject(Customer customer);


	void update(Customer customer);


	List<Customer> findByCondition(DetachedCriteria criteria);







}
