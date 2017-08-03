package com.jjjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlCityWA;
import com.jjjl.service.JlCityWAService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlCityWAServiceImpl implements JlCityWAService {

	@Autowired
	private BaseDAO<JlCityWA> baseDao;

	public BaseDAO<JlCityWA> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlCityWA> baseDao) {
		this.baseDao = baseDao;
	}


	
	public List<JlCityWA> findBycityCd(String cityCd) {
		String hql="from JlCityWA b where b.jlCityB.cityCd='"+cityCd+"' ORDER BY year ASC";
		return baseDao.find(hql);
	}

	
}
