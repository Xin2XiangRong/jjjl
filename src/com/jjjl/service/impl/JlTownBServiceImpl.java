package com.jjjl.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlTownB;
import com.jjjl.service.JlTownBService;
@SuppressWarnings("all")
@Service(value="jlTownBServiceImpl")
@Transactional
public class JlTownBServiceImpl implements JlTownBService {

	@Autowired
	private BaseDAO<JlTownB> baseDao;

	public BaseDAO<JlTownB> getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDAO<JlTownB> baseDao) {
		this.baseDao = baseDao;
	}

	public List<JlTownB> findByCountyCd(String countyCd) {
		// TODO Auto-generated method stub
		String hql="from JlTownB where jlCountyB.countyCd='"+countyCd+"'";
		
		JSONArray jsonArrayTown=JSONArray.fromObject(baseDao.find(hql));
		return jsonArrayTown;
	}

}
