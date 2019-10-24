package cn.lwc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lwc.entity.Linkman;

public interface LinkmanDao {

	int addLkm(Linkman linkman);

	List<Linkman> lkmList();

	List<Linkman> findLkmListByCondition(DetachedCriteria criteria);

	void updateByObject(Linkman linkman);

	void deleteByObject(Linkman linkman);

	Linkman findLkmByObject(Linkman linkman);

	int recordCount(DetachedCriteria criteria);

	List<Linkman> findLkmListByCondition(DetachedCriteria criteria, int startIndex, int pageRecordCount);

	List<Linkman> findListByCustId(int custId);

}
