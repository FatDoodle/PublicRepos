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
	 * ���÷��������ĳЩ�����µļ�¼��
	 */
	@Override
	public int getRecordCountByDetachedCriteria(DetachedCriteria criteria) {
		// �����ܼ�¼��
		criteria.setProjection(Projections.rowCount());
		int recordCount = lkmDao.recordCount(criteria);
		criteria.setProjection(null);
		return recordCount;
	}

	/**
	 * ��������ѯ
	 * 
	 * 1�������ܼ�¼������ֵ��pageBean���ܼ�¼���У����ڼ�����ҳ��
	 * 2�����ݵ�ǰ����ҳ��ÿҳ��¼���������ݣ������pageBean��list��s
	 */
	@Override
	public void lkmList(DetachedCriteria criteria, PageBean<Linkman> pageBean) {
		// �����ܼ�¼��
		pageBean.setRecordCount(getRecordCountByDetachedCriteria(criteria));
		
		//����pageBean�����Ϣ��ѯ��ǰҳ����ϵ���б�
		List<Linkman> list=lkmDao.findLkmListByCondition(criteria,pageBean.getStartIndex(),pageBean.getPageRecordCount());
		pageBean.setData(list);
	}



	@Override
	public  List<Linkman> findListByCustId(int custId) {
		return lkmDao.findListByCustId(custId);
	}

}
