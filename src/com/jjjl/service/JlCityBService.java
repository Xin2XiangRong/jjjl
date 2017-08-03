package com.jjjl.service;

import java.util.List;

import com.jjjl.data.JlCityB;

public interface JlCityBService {

	public List<JlCityB> findAll();
	public List<JlCityB> findByMapid(String mapid);
	public JlCityB findByCityCd(String cityCd);
}
