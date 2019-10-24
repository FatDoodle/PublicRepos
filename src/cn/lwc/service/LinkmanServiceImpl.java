package cn.lwc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lwc.dao.LinkmanDao;
import cn.lwc.entity.Linkman;
import cn.lwc.entity.PageBean;

@Service
@Transactional
public class LinkmanServiceImpl implements LinkmanService {

	@Autowired
	private LinkmanDao lkmDao;

	@Override
	public int addLkm(Linkman linkman) {
		// TODO Auto-generated method stub
		return lkmDao.addLkm(linkman);
	}

	

	@Override
	public void editLkm(Linkman linkman) {
		lkmDao.updateByObject(linkman);
	}

	@Override
	public void deleteLkm(Linkman linkman) {
		lkmDao.deleteByObject(linkman);
	}

	public Linkman findLkmByObject(Linkman linkman) {
		return lkmDao.findLkmByObject(linkman);
	}

	/**
	 * 公用方法，获得某些条件下的记录数
	 */
	@Override
	public int getRecordCountByDetachedCriteria(DetachedCriteria criteria) {
		// 查找总记录数
		criteria.setProjection(Projections.rowCount());
		int recordCount = lkmDao.recordCount(criteria);
		criteria.setProjection(null);
		return recordCount;
	}

	/**
	 * 非条件查询
	 * 
	 * 1：查找总记录数，赋值给pageBean的总记录数中，便于计算总页数
	 * 2：根据当前所在页和每页记录数查找数据，存放在pageBean的list中s
	 */
	@Override
	public void lkmList(DetachedCriteria criteria, PageBean<Linkman> pageBean) {
		// 查找总记录数
		pageBean.setRecordCount(getRecordCountByDetachedCriteria(criteria));
		
		//根据pageBean里的信息查询当前页的联系人列表
		List<Linkman> list=lkmDao.findLkmListByCondition(criteria,pageBean.getStartIndex(),pageBean.getPageRecordCount());
		pageBean.setData(list);
	}



	@Override
	public  List<Linkman> findListByCustId(int custId) {
		return lkmDao.findListByCustId(custId);
	}

}
