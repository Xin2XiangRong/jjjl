package com.jjjl.service;

import java.util.List;

import com.jjjl.data.JlCityWB;

public interface JlCityWBService {

	public List<JlCityWB> findByyear(String year);	
	List<JlCityWB> findBycityCd(String cityCd);
}
