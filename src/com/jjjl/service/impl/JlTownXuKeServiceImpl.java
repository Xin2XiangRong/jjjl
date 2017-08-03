package com.jjjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlTownXuKe;
import com.jjjl.service.JlTownXuKeService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlTownXuKeServiceImpl implements JlTownXuKeService {

	@Autowired
	private BaseDAO<JlTownXuKe> baseDao;

	public BaseDAO<JlTownXuKe> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlTownXuKe> baseDao) {
		this.baseDao = baseDao;
	}
	
	public int count(String hql) {
		// TODO Auto-generated method stub
		String hql1="select count(*) "+hql;
		return baseDao.count(hql1).intValue();
	}
	@Override
	public List<JlTownXuKe> find(String hql, int start, int length) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, start, length);
	}

	public List<JlTownXuKe> findByXiangCd(String xiangCd) {
		String hql="from JlTownXuKe b where b.jlTownB.xiangCd='"+xiangCd+"'";
		return baseDao.find(hql);
	}
	
}
