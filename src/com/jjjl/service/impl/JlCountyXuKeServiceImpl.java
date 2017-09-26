package com.jjjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlCountyXuKe;
import com.jjjl.service.JlCountyXuKeService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlCountyXuKeServiceImpl implements JlCountyXuKeService {

	@Autowired
	private BaseDAO<JlCountyXuKe> baseDao;

	public BaseDAO<JlCountyXuKe> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlCountyXuKe> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<JlCountyXuKe> findByCityCd(String cityCd) {
		// TODO Auto-generated method stub
		String hql="from JlCountyXuKe where jlCountyB.jlCityB.cityCd='"+cityCd+"'";
		return baseDao.find(hql);
	}
	
}
