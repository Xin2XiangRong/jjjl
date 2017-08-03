package com.jjjl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlExchWellHourR;
import com.jjjl.service.JlExchWellHourRService;
@SuppressWarnings("all")
@Service
@Transactional
public class JlExchWellHourRServiceImpl implements JlExchWellHourRService {

	@Autowired
	private BaseDAO<JlExchWellHourR> baseDao;

	public BaseDAO<JlExchWellHourR> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlExchWellHourR> baseDao) {
		this.baseDao = baseDao;
	}
	

}
