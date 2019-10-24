package cn.lwc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.lwc.entity.Linkman;

@Repository
public class LinkmanDaoImpl implements LinkmanDao {

	@Autowired
	private HibernateTemplate hibernate;
	@Override
	public int addLkm(Linkman linkman) {
		hibernate.save(linkman);
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Linkman> lkmList() {
		return (List<Linkman>) hibernate.find("from Linkman");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Linkman> findLkmListByCondition(DetachedCriteria criteria) {
		return (List<Linkman>) hibernate.findByCriteria(criteria);
	}

	@Override
	public void updateByObject(Linkman linkman) {
		hibernate.update(linkman);
	}

	@Override
	public void deleteByObject(Linkman linkman) {
		hibernate.delete(linkman);
	}

	public Linkman findLkmByObject(Linkman linkman) {
		return (Linkman) hibernate.get(Linkman.class,linkman.getLkmid());
	}

	@Override
	public int recordCount(DetachedCriteria criteria) {
		List<?> findByCriteria = hibernate.findByCriteria(criteria);
		int i=0;
		if(findByCriteria!=null&&findByCriteria.size()!=0){
			i=Integer.parseInt(findByCriteria.get(0).toString());
		}
		return i;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Linkman> findLkmListByCondition(DetachedCriteria criteria, int startIndex, int pageRecordCount) {
		return (List<Linkman>) hibernate.findByCriteria(criteria, startIndex, pageRecordCount);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Linkman> findListByCustId(int custId) {
		return (List<Linkman>) hibernate.find("from Linkman where customer.custId=?",custId);
	}

}
