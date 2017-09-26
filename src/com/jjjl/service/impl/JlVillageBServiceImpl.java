package com.jjjl.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.JlVillageB;
import com.jjjl.service.JlVillageBService;
@SuppressWarnings("all")
@Service(value="jlVillageBServiceImpl")
@Transactional
public class JlVillageBServiceImpl implements JlVillageBService {

	@Autowired
	private BaseDAO<JlVillageB> baseDao;
	public BaseDAO<JlVillageB> getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDAO<JlVillageB> baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public List<JlVillageB> findByXiangCd(String xiangCd) {
		// TODO Auto-generated method stub
		String hql="from JlVillageB where jlTownB.xiangCd='"+xiangCd+"'";
		JSONArray jsonArrayVillage=JSONArray.fromObject(baseDao.find(hql));
		return jsonArrayVillage;
	}

}
