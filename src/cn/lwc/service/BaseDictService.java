package cn.lwc.service;

import java.util.List;

import cn.lwc.entity.BaseDict;

public interface BaseDictService {

	List<BaseDict> findBaseDictByTypeCode(String string);

}
