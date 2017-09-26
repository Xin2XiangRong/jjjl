package com.jjjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlExchAutoWellB;
import com.jjjl.service.JlExchAutoWellBService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlExchAutoWellBServiceImpl implements JlExchAutoWellBService {

	@Autowired
	private BaseDAO<JlExchAutoWellB> baseDao;

	public BaseDAO<JlExchAutoWellB> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlExchAutoWellB> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<JlExchAutoWellB> find(String hql, int start, int length) {
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
	public JlExchAutoWellB findByWellCd(String wellCd) {
		// TODO Auto-generated method stub
		return baseDao.get(JlExchAutoWellB.class, wellCd);
	}
	
	@Override
	public void addWell(JlExchAutoWellB autoWellB) {
		baseDao.saveOrUpdate(autoWellB);
	}
	
}
