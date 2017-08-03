package com.jjjl.service;

import java.util.List;

import com.jjjl.data.SysUserB;

public interface SysUserBService  {

	public void save(SysUserB sysUserB);
	public void update(SysUserB sysUserB);
	public void delete(SysUserB sysUserB);
	public SysUserB queryByUserID(String userid);
	public boolean validateByUserID(String userid);
	public boolean validateByUserIDAndPassword(String userid,String password);
	public int count(String hql);
	public List<SysUserB> find(String hql, int start,int length);
}
