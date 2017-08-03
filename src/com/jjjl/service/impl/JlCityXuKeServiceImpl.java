package com.jjjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlCityWA;
import com.jjjl.data.JlCityXuKe;
import com.jjjl.service.JlCityXuKeService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlCityXuKeServiceImpl implements JlCityXuKeService {

	@Autowired
	private BaseDAO<JlCityXuKe> baseDao;

	public BaseDAO<JlCityXuKe> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlCityXuKe> baseDao) {
		this.baseDao = baseDao;
	}
	
	public int count(String hql) {
		// TODO Auto-generated method stub
		String hql1="select count(*) "+hql;
		return baseDao.count(hql1).intValue();
	}
	@Override
	public List<JlCityXuKe> find(String hql, int start, int length) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, start, length);
	}
	
	public List<JlCityXuKe> findByyear(String year) {
		// TODO Auto-generated method stub
		String hql="from JlCityXuKe b where b.year='"+year+"'";
		return baseDao.find(hql);
	}
	
	public List<JlCityXuKe> findBycityCd(String cityCd) {
		String hql="from JlCityXuKe b where b.jlCityB.cityCd='"+cityCd+"'";
		return baseDao.find(hql);
	}
	
}
