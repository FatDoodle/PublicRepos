package cn.lwc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lwc.entity.Visit;

public interface VisitDao {

	void save(Visit visit);

	List<Visit> findVisitListByCondition(DetachedCriteria criteria, int startIndex, int pageRecordCount);

	int recordCount(DetachedCriteria criteria);

	Visit findVisit(Visit visit);

	void update(Visit visit);

	void delete(Visit visit);

}
