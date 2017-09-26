package com.jjjl.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjjl.dao.BaseDAO;
import com.jjjl.data.WellBMonthWV;
import com.jjjl.service.WellBMonthWVService;
@SuppressWarnings("all")
@Service
@Transactional
public class WellBMonthWVServiceImpl implements WellBMonthWVService {

	@Autowired
	private BaseDAO<WellBMonthWV> baseDao;
	
	public BaseDAO<WellBMonthWV> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<WellBMonthWV> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public WellBMonthWV findByWellCd(String wellCd) {
		// TODO Auto-generated method stub
		System.out.println("mmmmmmm");
		System.out.println("Month"+wellCd);

		return baseDao.get(WellBMonthWV.class, wellCd);
	}

	@Override
	public void setMonthW(WellBMonthWV wellBMonthWV) {
		Random random=new Random();
		Integer r = random.nextInt(1000)+1000;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		System.out.println(sdf.format(date)); 
		
		BigDecimal dayW=new BigDecimal(r);
		String month=sdf.format(date);
		wellBMonthWV.setMonthW(dayW);
		wellBMonthWV.setYearmonth(month);
		baseDao.saveOrUpdate(wellBMonthWV);
	}

}
