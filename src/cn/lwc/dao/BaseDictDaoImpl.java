package cn.lwc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.lwc.entity.BaseDict;

@Repository
public class BaseDictDaoImpl implements BaseDictDao {
	
	@Autowired
	private HibernateTemplate hibernate;

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseDict> findBaseDictByTypeCode(String string) {
		List<BaseDict> find = (List<BaseDict>) hibernate.find("from BaseDict where dictTypeCode=?", string);
		return find;
	}

}
