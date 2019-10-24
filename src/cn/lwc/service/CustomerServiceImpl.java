package cn.lwc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lwc.dao.CustomerDao;
import cn.lwc.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao custDao;

	@Override
	public void saveCust(Customer customer) {
		custDao.save(customer);
	}


	@Override
	public List<Customer> findCustList() {
		return custDao.findCustList();
	}


	@Override
	public void deleteByObject(Customer customer) {
		custDao.deleteByObject(customer);
	}

	@Override
	public Customer findCustByObject(Customer customer) {
		return custDao.findCustByObject(customer);
	}

	@Override
	public void update(Customer customer) {
		custDao.update(customer);
	}


	@Override
	public List<Customer> findByCondition(DetachedCriteria criteria) {
		
		return custDao.findByCondition(criteria);
	}



}
