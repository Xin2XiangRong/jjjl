package com.jjjl.service;

import java.util.List;

import com.jjjl.data.JlCountyXuKe;

public interface JlCountyXuKeService {

	public List<JlCountyXuKe> findByCityCd(String cityCd);
}
