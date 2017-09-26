package com.jjjl.service;

import java.util.List;

import com.jjjl.data.JlCityXuKe;

public interface JlCityXuKeService {
	public int count(String hql);
	public List<JlCityXuKe> find(String hql, int start,int length);
	public List<JlCityXuKe> findByyear(String year);	
	public List<JlCityXuKe> findBycityCd(String cityCd);
}
