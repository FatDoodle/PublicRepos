package cn.lwc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lwc.dao.BaseDictDao;
import cn.lwc.entity.BaseDict;

@Service
@Transactional
public class BaseDiceServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictDao bdd;
	

//	public void setBdd(BaseDictDao bdd) {
//		this.bdd = bdd;
//	}

	@Override
	public List<BaseDict> findBaseDictByTypeCode(String string) {
		return bdd.findBaseDictByTypeCode(string);
	}

}
