package cn.lwc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lwc.entity.Linkman;
import cn.lwc.entity.PageBean;

public interface LinkmanService {

	int addLkm(Linkman linkman);



	void editLkm(Linkman linkman);

	void deleteLkm(Linkman linkman);

	Linkman findLkmByObject(Linkman linkman);

	int getRecordCountByDetachedCriteria(DetachedCriteria criteria);


	void lkmList(DetachedCriteria criteria, PageBean<Linkman> pageBean);



	List<Linkman> findListByCustId(int custId);





}
