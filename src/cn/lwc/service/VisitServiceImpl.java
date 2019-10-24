package cn.lwc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lwc.dao.VisitDao;
import cn.lwc.entity.Linkman;
import cn.lwc.entity.PageBean;
import cn.lwc.entity.Visit;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {
	@Autowired
	private VisitDao visitDao;

	@Override
	public void save(Visit visit) {
		visitDao.save(visit);
	}

	public void visitList(DetachedCriteria criteria, PageBean<Visit> pageBean) {
		// 查找总记录数
		pageBean.setRecordCount(getRecordCountByDetachedCriteria(criteria));

		// 根据pageBean里的信息查询当前页的联系人列表
		List<Visit> list = visitDao.findVisitListByCondition(criteria, pageBean.getStartIndex(),
				pageBean.getPageRecordCount());
		pageBean.setData(list);
	}
	
	@Override
	public int getRecordCountByDetachedCriteria(DetachedCriteria criteria) {
		// 查找总记录数
		criteria.setProjection(Projections.rowCount());
		int recordCount = visitDao.recordCount(criteria);
		criteria.setProjection(null);
		return recordCount;
	}

	@Override
	public Visit findVisit(Visit visit) {
		return visitDao.findVisit(visit);
	}

	@Override
	public void update(Visit visit) {
		visitDao.update(visit);
	}

	@Override
	public void delete(Visit visit) {
		visitDao.delete(visit);
	}

}
