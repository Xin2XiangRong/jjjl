package com.jjjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlExchWellB;
import com.jjjl.service.JlExchWellBService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlExchWellBServiceImpl implements JlExchWellBService {

	@Autowired
	private BaseDAO<JlExchWellB> baseDao;

	public BaseDAO<JlExchWellB> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlExchWellB> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<JlExchWellB> find(String hql) {
		return baseDao.find(hql);
	}
	@Override
	public List<JlExchWellB> find(String hql, int start, int length) {
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
	public JlExchWellB findByWellCd(String wellCd) {
		// TODO Auto-generated method stub
		System.out.println("*****"+wellCd);

		return baseDao.get(JlExchWellB.class, wellCd);
	}
	
	@Override
	public void update(JlExchWellB wellB) {
		baseDao.saveOrUpdate(wellB);
		System.out.println(wellB.getWellNm()+"ser");
	}
	
	@Override
	public void delete(JlExchWellB wellB) {
		baseDao.delete(wellB);
	}
	
	@Override
	public void addWell(JlExchWellB wellB) {
		baseDao.save(wellB);
	}

	
}
