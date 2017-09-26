package com.jjjl.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlCityB;
import com.jjjl.service.JlCityBService;
@SuppressWarnings("all")
@Service(value="jlCityBServiceImpl")
@Transactional
public class JlCityBServiceImpl implements JlCityBService {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BaseDAO<JlCityB> baseDao;
	
	
	public BaseDAO<JlCityB> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<JlCityB> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<JlCityB> findAll() {
		// TODO Auto-generated method stub
		
		String hql="from JlCityB";
		return baseDao.find(hql);
	}

	@Override
	public List<JlCityB> findByMapid(String mapid) {
		// TODO Auto-generated method stub
		String hql="";
		if(mapid.endsWith("1400")){
			hql="from JlCityB where cityCd not in ('14')";
		}else{
			hql="from JlCityB where cityCd='"+mapid+"'";
			log.info("****findByMapid1***"+mapid);
			System.out.println(baseDao.find(hql).get(0).getCityCd());

		}
		JSONArray jsonArrayCity=JSONArray.fromObject(baseDao.find(hql));
		return jsonArrayCity;
	}
	
	@Override
	public JlCityB findByCityCd(String cityCd) {
		
		return baseDao.get(JlCityB.class, cityCd);
	}

}
