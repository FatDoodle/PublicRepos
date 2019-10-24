package cn.lwc.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.lwc.entity.PageBean;
import cn.lwc.entity.Visit;

public interface VisitService {

	void save(Visit visit);

	void visitList(DetachedCriteria criteria, PageBean<Visit> pageBean);

	int getRecordCountByDetachedCriteria(DetachedCriteria criteria);

	Visit findVisit(Visit visit);

	void update(Visit visit);

	void delete(Visit visit);
	
}
