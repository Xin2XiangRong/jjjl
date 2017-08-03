package com.jjjl.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlCountyB;
import com.jjjl.service.JlCountyBService;
@SuppressWarnings("all")
@Service(value="jlCountyBServiceImpl")
@Transactional
public class JlCountyBServiceImpl implements JlCountyBService {

	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BaseDAO<JlCountyB> baseDao;

	public BaseDAO<JlCountyB> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlCountyB> baseDao) {
		this.baseDao = baseDao;
	}

	public List<JlCountyB> findByCityCd(String cityCd) {
		// TODO Auto-generated method stub
		String hql="from JlCountyB where jlCityB.cityCd='"+cityCd+"'";
		
		log.info("****findByCityCd***"+cityCd);
		System.out.println((baseDao.find(hql).get(0).getCountyNm()));
		
		JSONArray jsonArrayCounty=JSONArray.fromObject(baseDao.find(hql));
		return jsonArrayCounty;
	}
	
	
}
