package com.jjjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlTownWT;
import com.jjjl.service.JlTownWTService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlTownWTServiceImpl implements JlTownWTService {

	@Autowired
	private BaseDAO<JlTownWT> baseDao;

	public BaseDAO<JlTownWT> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlTownWT> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<JlTownWT> find(String hql, int start, int length) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, start, length);
	}

	@Override
	public int count(String hql) {
		// TODO Auto-generated method stub	
		String hql1="select count(*) "+hql;
		return baseDao.count(hql1).intValue();
	}

	
	@Override
	public void add(JlTownWT townWT) {
		baseDao.saveOrUpdate(townWT);
	}
	
}
