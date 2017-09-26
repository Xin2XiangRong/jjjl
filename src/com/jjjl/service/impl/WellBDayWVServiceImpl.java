package com.jjjl.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.WellBDayWV;
import com.jjjl.service.WellBDayWVService;
@SuppressWarnings("all")
@Service
@Transactional
public class WellBDayWVServiceImpl implements WellBDayWVService {

	@Autowired
	private BaseDAO<WellBDayWV> baseDao;
	
	public BaseDAO<WellBDayWV> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<WellBDayWV> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public WellBDayWV findByWellCd(String wellCd) {
		// TODO Auto-generated method stub
		return baseDao.get(WellBDayWV.class, wellCd);
	}
	
	@Override
	public void setDayW(WellBDayWV wellBDayWV) {
		Random random=new Random();
		Integer r = random.nextInt(50)+50;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date)); 
		
		BigDecimal dayW=new BigDecimal(r);
		String day=sdf.format(date);
		wellBDayWV.setDayW(dayW);
		wellBDayWV.setDay(day);
		baseDao.saveOrUpdate(wellBDayWV);
	}

}
