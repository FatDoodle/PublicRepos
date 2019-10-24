package cn.lwc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.lwc.entity.Visit;

@Repository
public class VisitDaoImpl implements VisitDao{
	@Autowired
	private HibernateTemplate hibernate;

	@Override
	public void save(Visit visit) {
		hibernate.save(visit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> findVisitListByCondition(DetachedCriteria criteria, int startIndex, int pageRecordCount) {

		return (List<Visit>) hibernate.findByCriteria(criteria,startIndex,pageRecordCount);
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

	@Override
	public Visit findVisit(Visit visit) {
		return hibernate.get(Visit.class, visit.getVisitId());
	}

	@Override
	public void update(Visit visit) {
		hibernate.update(visit);
	}

	@Override
	public void delete(Visit visit) {
		hibernate.delete(visit);
	}


	
}
