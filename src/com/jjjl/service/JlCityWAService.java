package com.jjjl.service;

import java.util.List;

import com.jjjl.data.JlCityWA;

public interface JlCityWAService {
	
	public List<JlCityWA> findBycityCd(String cityCd);
	
}
