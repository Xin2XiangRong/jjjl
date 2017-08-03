package com.jjjl.service;

import java.util.List;

import com.jjjl.data.JlExchAutoWellB;



public interface JlExchAutoWellBService  {

	public List<JlExchAutoWellB> find(String hql, int start,int length);
	public int count(String hql);
	public JlExchAutoWellB findByWellCd(String wellCd);
	public void addWell(JlExchAutoWellB autoWellB);
}
