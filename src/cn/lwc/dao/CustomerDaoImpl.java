package cn.lwc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.lwc.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(Customer customer) {
		hibernateTemplate.save(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findCustList() {
		return (List<Customer>) hibernateTemplate.find("from Customer");
	}
	
	@Override
	public void deleteByObject(Customer customer) {
		hibernateTemplate.delete(customer);
	}

	@Override
	public Customer findCustByObject(Customer customer) {
		return hibernateTemplate.get(Customer.class, customer.getCustId());
	}

	@Override
	public void update(Customer customer) {
		hibernateTemplate.update(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByCondition(DetachedCriteria criteria) {
		
		return (List<Customer>) hibernateTemplate.findByCriteria(criteria);
	}

	

	
	
}
