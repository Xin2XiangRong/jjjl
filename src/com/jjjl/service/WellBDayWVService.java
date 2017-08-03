package com.jjjl.service;

import com.jjjl.data.WellBDayWV;

public interface WellBDayWVService {

	public WellBDayWV findByWellCd(String wellCd);
	public void setDayW(WellBDayWV wellBDayWV);
}
