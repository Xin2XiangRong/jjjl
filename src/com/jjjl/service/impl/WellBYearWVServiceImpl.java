package com.jjjl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.WellBYearWV;
import com.jjjl.service.WellBYearWVService;
@SuppressWarnings("all")
@Service
@Transactional
public class WellBYearWVServiceImpl implements WellBYearWVService {

	@Autowired
	private BaseDAO<WellBYearWV> baseDao;
	
	public BaseDAO<WellBYearWV> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<WellBYearWV> baseDao) {
		this.baseDao = baseDao;
	}

	public WellBYearWV findByWellCd(String wellCd) {
		// TODO Auto-generated method stub
		System.out.println("Year"+wellCd);
		return baseDao.get(WellBYearWV.class, wellCd);
	}

}
