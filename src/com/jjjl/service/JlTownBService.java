package com.jjjl.service;

import java.util.List;

import com.jjjl.data.JlTownB;

public interface JlTownBService {

	public List<JlTownB> findByCountyCd(String countyCd);
}
