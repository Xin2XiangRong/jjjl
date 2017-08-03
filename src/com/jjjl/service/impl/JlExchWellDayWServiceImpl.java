package com.jjjl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlExchWellDayW;
import com.jjjl.service.JlExchWellDayWService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlExchWellDayWServiceImpl implements JlExchWellDayWService {

	@Autowired
	private BaseDAO<JlExchWellDayW> baseDao;

	public BaseDAO<JlExchWellDayW> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlExchWellDayW> baseDao) {
		this.baseDao = baseDao;
	}
	
	

}
