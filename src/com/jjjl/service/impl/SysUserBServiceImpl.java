package com.jjjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.SysUserB;
import com.jjjl.service.SysUserBService;
@SuppressWarnings("all")
@Service
@Transactional
public class SysUserBServiceImpl implements SysUserBService {

	@Autowired
	private BaseDAO<SysUserB> baseDao;

	public BaseDAO<SysUserB> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<SysUserB> baseDao) {
		this.baseDao = baseDao;
	}

	

	@Override
	public void save(SysUserB sysUserB) {
		// TODO Auto-generated method stub
		baseDao.save(sysUserB);
	}

	@Override
	public void update(SysUserB sysUserB) {
		// TODO Auto-generated method stub
		baseDao.update(sysUserB);
	}

	@Override
	public void delete(SysUserB sysUserB) {
		// TODO Auto-generated method stub
		baseDao.delete(sysUserB);
	}

	@Override
	public SysUserB queryByUserID(String userid) {
		// TODO Auto-generated method stub
		return baseDao.get(SysUserB.class, userid);
	}

	@Override
	public boolean validateByUserID(String userid) {		
		// TODO Auto-generated method stub
		boolean flag=false;
		SysUserB sysUserB=queryByUserID(userid);
		if(sysUserB!=null){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean validateByUserIDAndPassword(String userid, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		SysUserB sysUserB=queryByUserID(userid);
		if(sysUserB!=null){
			if(sysUserB.getPassword().equals(password)){
				flag=true;
			}
		}
		return flag;
	}
	
	@Override
	public int count(String hql) {
		// TODO Auto-generated method stub
		String hql1="select count(*) "+hql;
		return baseDao.count(hql1).intValue();
	}
	@Override
	public List<SysUserB> find(String hql, int start, int length) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, start, length);
	}

}
