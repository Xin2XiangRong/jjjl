package com.jjjl.action.control;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jjjl.data.JlExchAutoWellB;
import com.jjjl.data.WellBDayWV;
import com.jjjl.data.WellBMonthWV;
import com.jjjl.data.WellBYearWV;
import com.jjjl.data.autoWell.AutoWellB;
import com.jjjl.service.JlExchAutoWellBService;
import com.jjjl.service.WellBDayWVService;
import com.jjjl.service.WellBMonthWVService;
import com.jjjl.service.WellBYearWVService;
import com.jjjl.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("all")
@Controller
public class AutoWellBAction extends ActionSupport {
	
	private JlExchAutoWellBService autoWellBService;	
	private WellBDayWVService wellBDayWVService;	
	private WellBMonthWVService wellBMonthWVService;	
	private WellBYearWVService wellBYearWVService;
	private static final String NODATA = "nodata";
	private Logger log=Logger.getLogger(this.getClass());
	private String cityCd;
	private Integer currentPage;
	private String countyCd;
	private String xiangCd;
	private String p801004;
	private String p801011;
	private String p801022;
	private String wellNm;
	private String wellCd;

	

	public WellBDayWVService getWellBDayWVService() {
		return wellBDayWVService;
	}
	@Autowired
	public void setWellBDayWVService(WellBDayWVService wellBDayWVService) {
		this.wellBDayWVService = wellBDayWVService;
	}
	public WellBMonthWVService getWellBMonthWVService() {
		return wellBMonthWVService;
	}
	@Autowired
	public void setWellBMonthWVService(WellBMonthWVService wellBMonthWVService) {
		this.wellBMonthWVService = wellBMonthWVService;
	}
	public WellBYearWVService getWellBYearWVService() {
		return wellBYearWVService;
	}
	@Autowired
	public void setWellBYearWVService(WellBYearWVService wellBYearWVService) {
		this.wellBYearWVService = wellBYearWVService;
	}
	public JlExchAutoWellBService getAutoWellBService() {
		return autoWellBService;
	}
	@Autowired
	public void setAutoWellBService(JlExchAutoWellBService autoWellBService) {
		this.autoWellBService = autoWellBService;
	}

	public String getCityCd() {
		return cityCd;
	}

	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getCountyCd() {
		return countyCd;
	}

	public void setCountyCd(String countyCd) {
		this.countyCd = countyCd;
	}

	public String getXiangCd() {
		return xiangCd;
	}

	public void setXiangCd(String xiangCd) {
		this.xiangCd = xiangCd;
	}

	public String getP801004() {
		return p801004;
	}

	public void setP801004(String p801004) {
		this.p801004 = p801004;
	}

	public String getP801011() {
		return p801011;
	}

	public void setP801011(String p801011) {
		this.p801011 = p801011;
	}

	public String getP801022() {
		return p801022;
	}

	public void setP801022(String p801022) {
		this.p801022 = p801022;
	}

	public String getWellNm() {
		return wellNm;
	}

	public void setWellNm(String wellNm) {
		this.wellNm = wellNm;
	}

	public String getWellCd() {
		return wellCd;
	}

	public void setWellCd(String wellCd) {
		this.wellCd = wellCd;
	}

	public static String getNodata() {
		return NODATA;
	}

	public String query()throws Exception{
		
		log.info("该用户使用查询监测井列表功能");
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session=context.getSession();
		String  hql="from JlExchAutoWellB b where 1=1 ";
		if(xiangCd!=null && !xiangCd.equals("")){
			hql=hql+" and b.jlExchWellB.jlTownB.xiangCd like '"+xiangCd+"%'";
		}
		if(countyCd!=null && !countyCd.equals("")){
			hql=hql+" and b.jlExchWellB.jlTownB.xiangCd like '"+countyCd+"%'";
		}
		if(cityCd!=null && !cityCd.equals("")){
			hql=hql+" and b.jlExchWellB.jlTownB.xiangCd like '"+cityCd+"%'";
		}		
		if(p801004!=null && !p801004.equals("")){
			if(p801004.equals("1")){
				hql=hql+" and b.jlExchWellB.p801004 < 50 ";
			}
			if(p801004.equals("2")){
				hql=hql+" and b.jlExchWellB.p801004 >= 50 and b.jlExchWellB.p801004 <100";
			}
			if(p801004.equals("3")){
				hql=hql+" and b.jlExchWellB.p801004 >= 100 and b.jlExchWellB.p801004 <500";
			}
			if(p801004.equals("4")){
				hql=hql+" and b.jlExchWellB.p801004 >=500";
			}
		}
		if(p801011!=null && !p801011.equals("")){
			if(p801011.equals("1")){
				hql=hql+" and b.jlExchWellB.p801011 < 20 ";
			}
			if(p801011.equals("2")){
				hql=hql+" and b.jlExchWellB.p801011 >= 20 and b.jlExchWellB.p801011<50 ";
			}
			if(p801011.equals("3")){
				hql=hql+" and b.jlExchWellB.p801011 >= 50 and b.jlExchWellB.p801011<100 ";
			}
			if(p801011.equals("4")){
				hql=hql+" and b.jlExchWellB.p801011 >= 100 ";
			}
		}
		if(p801022!=null && !p801022.equals("")){
			hql=hql+" and b.jlExchWellB.p801022 = '"+p801022+"' ";
		}
		if(wellNm!=null && !wellNm.equals("")){
			hql=hql+" and b.jlExchWellB.wellNm like '%"+wellNm+"%'";
		}
		
		Page page=new Page();
		if(currentPage==null){
    		currentPage=1;
    	}
    	page.setCurrentPage(currentPage);
    	page.setEveryPage(15);
    	List<JlExchAutoWellB> listJlExchAutoWellB=autoWellBService.find(hql, page.getBeginIndex(), page.getEveryPage());    	
    	if(listJlExchAutoWellB!=null && listJlExchAutoWellB.size()>0){
    		int total=autoWellBService.count(hql);
    		List<AutoWellB> autoWellBList=new ArrayList<AutoWellB>();
    		for(int i=0;i<listJlExchAutoWellB.size();i++){
    			AutoWellB autoWellB=new AutoWellB();
    			System.out.println("1111111111");
    			autoWellB.setWellCd(listJlExchAutoWellB.get(i).getWellCd());
    			System.out.println("2222222222");

    			autoWellB.setWellNm(listJlExchAutoWellB.get(i).getJlExchWellB().getWellNm());
    			autoWellB.setP801004(listJlExchAutoWellB.get(i).getJlExchWellB().getP801004());
    			WellBYearWV wellBYearWV= wellBYearWVService.findByWellCd(listJlExchAutoWellB.get(i).getWellCd());
    			
    			if(wellBYearWV!=null){
    				autoWellB.setYearW(wellBYearWV.getYearW().doubleValue());
    			}else{
    				autoWellB.setYearW(0.00);
    			}
    			WellBMonthWV wellBMonthWV =wellBMonthWVService.findByWellCd(listJlExchAutoWellB.get(i).getWellCd());
    			if(wellBMonthWV!=null){
    				autoWellB.setMonthW(wellBMonthWV.getMonthW().doubleValue());
    			}else{
    				autoWellB.setMonthW(0.00);
    			}
    			WellBDayWV wellBDayWV=wellBDayWVService.findByWellCd(listJlExchAutoWellB.get(i).getWellCd());
    			if(wellBDayWV!=null){
    				autoWellB.setDayW(wellBDayWV.getDayW().doubleValue());;
    			}else{
    				autoWellB.setDayW(0.00);
    			}
    			autoWellBList.add(autoWellB);
    		}
    		if(autoWellBList!=null && autoWellBList.size()>0){
    			page.setTotalPage(total);
    			session.put("autoWellBList", autoWellBList);
    			session.put("page", page);
    			return SUCCESS;
    		}else{
    			return NODATA;
    		}
    		
    	}else{
    		return NODATA;
    	}
    	
	}
	
	public String detail()throws Exception{
		
		log.info("该用户使用查询监测井详情功能");
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session=context.getSession();
		if(wellCd!=null && !wellCd.equalsIgnoreCase("")){
			JlExchAutoWellB autoWellBDetail =autoWellBService.findByWellCd(wellCd);
			if(autoWellBDetail!=null){
				session.put("autoWellBDetail", autoWellBDetail);
				return SUCCESS;
			}else{
				return NODATA;
			}
		}else{
			return NODATA;
		}
		
	}
	@Test
	public String yongshui() throws Exception{
		
		log.info("该用户使用查询监测井用水信息功能");
		ActionContext context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		/**
		 * 日用水量。月用水量的原始数据，分别以三十天、十二个月为计量
		 */
		Queue<WellBDayWV> listD=new ArrayBlockingQueue<WellBDayWV>(30);
		Queue<WellBMonthWV> listM= new  ArrayBlockingQueue<WellBMonthWV>(12);
		/*for(int i=0;i<30;i++) {
			Random random = new Random();
			int r = random.nextInt(50)+50;		//生成50-100的随机数作为用水量
			BigDecimal bignum1 = new BigDecimal(r); 
			String dayStr=new StringBuilder("2017/01/").append(i+1).toString();
			WellBDayWV wellBDayWV=new WellBDayWV(dayStr,bignum1);
			listD.add(wellBDayWV);
		}
		for(int j=0;j<12;j++) {
			Random random = new Random();
			int r= random.nextInt(1000)+1000;		//生成1000-2000的随机用水量
			BigDecimal bignum2 = new BigDecimal(r);
			String monStr= new StringBuilder("2017/").append(j+1).toString();
			WellBMonthWV wellBMonthWV=new WellBMonthWV(wellCd,monStr,bignum2);
			listM.add(wellBMonthWV);
		}*/
		
		
		if(wellCd!=null && !wellCd.equalsIgnoreCase("")){
			WellBDayWV wellBDayWV=wellBDayWVService.findByWellCd(wellCd);	//按照机井编号查找当日用水量
			if(wellBDayWV!=null) {
				listD.add(wellBDayWV);
				String day=wellBDayWV.getDay();			//取得当日日期
				String cpday=day.substring(day.length()-2, day.length());	//去掉年份、月份，并转化为int类型
				int d=Integer.parseInt(cpday);
				String ym=day.substring(0, day.length()-2);		//截取年份、月份
			
				Random random = new Random();
			
				int j=d-1;
				for(int i=0;i<29;i++) {
					if(j>0 && j<d) {		//表示没有进入上一月份
						String dd=String.valueOf(j);
						if(dd.length()==1){
							dd="0"+dd;
						}
						StringBuilder ymd=new StringBuilder(ym);
						String dayStr=ymd.append(dd).toString();
						j--;
						int r = random.nextInt(50)+50;		//生成50-100的随机数作为用水量
						BigDecimal bignum1 = new BigDecimal(r); 
						WellBDayWV wellBDayWV1=new WellBDayWV(dayStr,bignum1);
						listD.add(wellBDayWV1);
					} else {
						if(j==0){			//作是否为负数判断
							j+=30;
						}
						String dd=String.valueOf(j);
						if(dd.length()==1){
							dd="0"+dd;
						}
						StringBuilder ymd=new StringBuilder(ym);
						String dayStr=ymd.append(dd).toString();
						String mString=String.valueOf((Integer.parseInt(dayStr.substring(5, 7))-1));	//截取月份并减1，转为字符串
						String dayString=dayStr.substring(0,5)+mString+dayStr.substring(7, 10);
						j--;
						int r = random.nextInt(50)+50;		//生成50-100的随机数作为用水量
						BigDecimal bignum1 = new BigDecimal(r); 
						WellBDayWV wellBDayWV1=new WellBDayWV(dayString,bignum1);
						listD.add(wellBDayWV1);
					}
				}
			}
			
			WellBMonthWV wellBMonthWV=wellBMonthWVService.findByWellCd(wellCd);	//按照机井编号查找当月用水量
			if(wellBMonthWV!=null) {
				listM.add(wellBMonthWV);
				String mon=wellBMonthWV.getYearmonth();			//取得当前日期，包括年份月份
				String cpmon=mon.substring(mon.length()-2, mon.length());	//去掉年份、，并转化为int类型
				int m=Integer.parseInt(cpmon);
				String year=mon.substring(0, mon.length()-2);		//截取年份
				Random random=new Random();
				int t=m-1;
				for(int i=0;i<11;i++) {
					if(t>0 && t<m) {		//表示没有进入上一年份
						String mm=String.valueOf(t);
						if(mm.length()==1) {
							mm="0"+mm;
						}
						StringBuilder y=new StringBuilder(year);
						String monStr=y.append(mm).toString();
						t--;
						int r1 = random.nextInt(1000)+1000;		//生成1000-2000的随机数作为用水量
						BigDecimal bignum2 = new BigDecimal(r1); 
						WellBMonthWV wellBMonthWV1=new WellBMonthWV(monStr,bignum2);
						listM.add(wellBMonthWV1);
					} else {
						if(t==0) {			//作是否为负数判断
							t+=12;
						}
						String mm=String.valueOf(t);
						if(mm.length()==1) {
							mm="0"+mm;
						}
						StringBuilder y=new StringBuilder(year);
						String monStr=y.append(mm).toString();
						String yearStr=String.valueOf(Integer.parseInt(monStr.substring(0, 4))-1);
						String monString=yearStr+monStr.substring(4, 7);
						t--;
						int r1 = random.nextInt(1000)+1000;		//生成1000-2000的随机数作为用水量
						BigDecimal bignum2 = new BigDecimal(r1); 
						WellBMonthWV wellBMonthWV1=new WellBMonthWV(monString,bignum2);
					listM.add(wellBMonthWV1);
					}
				}
			}
		}
		
		if(listD!=null && listM!=null){
			session.put("wellBDayWV",listD);
			session.put("wellBMonthWV", listM);
			return SUCCESS;
		}
		else{
			return NODATA;
		}
	}
}
