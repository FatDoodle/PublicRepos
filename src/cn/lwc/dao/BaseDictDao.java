package cn.lwc.dao;

import java.util.List;

import cn.lwc.entity.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findBaseDictByTypeCode(String string);

}
