package com.jjjl.service;


import java.util.List;

import com.jjjl.data.JlTownWT;



public interface JlTownWTService  {

	public List<JlTownWT> find(String hql, int start,int length);
	public int count(String hql);
	public void add(JlTownWT townWT);
}
