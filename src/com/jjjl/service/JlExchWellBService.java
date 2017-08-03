package com.jjjl.service;

import java.util.List;

import com.jjjl.data.JlExchWellB;



public interface JlExchWellBService  {
	public List<JlExchWellB> find(String hql, int start,int length);
	public int count(String hql);
	public JlExchWellB findByWellCd(String wellCd);
	public void update(JlExchWellB wellB);
	public void delete(JlExchWellB wellB);
	public void addWell(JlExchWellB wellB);
	public List<JlExchWellB> find(String hql);
}
