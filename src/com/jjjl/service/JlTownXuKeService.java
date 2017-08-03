package com.jjjl.service;

import java.util.List;


import com.jjjl.data.JlTownXuKe;

public interface JlTownXuKeService {
	public int count(String hql);
	public List<JlTownXuKe> find(String hql, int start,int length);
	
	public List<JlTownXuKe> findByXiangCd(String xiangCd);
	
}
