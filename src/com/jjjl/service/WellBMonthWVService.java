package com.jjjl.service;


import com.jjjl.data.WellBMonthWV;

public interface WellBMonthWVService {
	
    public WellBMonthWV findByWellCd(String wellCd);
    public void setMonthW(WellBMonthWV wellBMonthWV);
}
