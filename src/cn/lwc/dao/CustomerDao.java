package cn.lwc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lwc.entity.Customer;

public interface CustomerDao {

	void save(Customer customer);

	List<Customer> findCustList();

	void deleteByObject(Customer customer);

	Customer findCustByObject(Customer customer);

	void update(Customer customer);

	List<Customer> findByCondition(DetachedCriteria criteria);


}
