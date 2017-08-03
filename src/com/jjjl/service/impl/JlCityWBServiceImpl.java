package com.jjjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlCityWB;
import com.jjjl.data.JlCityXuKe;
import com.jjjl.service.JlCityWBService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlCityWBServiceImpl implements JlCityWBService {

	@Autowired
	private BaseDAO<JlCityWB> baseDao;

	public BaseDAO<JlCityWB> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlCityWB> baseDao) {
		this.baseDao = baseDao;
	}

	public List<JlCityWB> findByyear(String year) {
		// TODO Auto-generated method stub
		String hql="from JlCityWB b where b.year='"+year+"'";
		return baseDao.find(hql);
	}
	
	public List<JlCityWB> findBycityCd(String cityCd) {
		String hql="from JlCityWB b where b.jlCityB.cityCd='"+cityCd+"'";
		return baseDao.find(hql);
	}
	
}
