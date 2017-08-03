package com.jjjl.service;

import java.util.List;

import com.jjjl.data.JlCountyB;

public interface JlCountyBService {

	public List<JlCountyB> findByCityCd(String cityCd);
}
