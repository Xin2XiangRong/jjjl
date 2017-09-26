package com.jjjl.action.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;











import com.jjjl.data.JlCityB;
import com.jjjl.data.JlCityXuKe;
import com.jjjl.data.JlTownWT;
import com.jjjl.data.JlTownXuKe;
import com.jjjl.service.JlCityBService;
import com.jjjl.service.JlCityXuKeService;
import com.jjjl.service.JlTownWTService;
import com.jjjl.service.JlTownXuKeService;
import com.jjjl.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
@Controller
public class WaterFPAction extends ActionSupport{
	private Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private JlCityXuKeService waterXKService;
	@Autowired
	private JlCityBService cityBService;
	@Autowired
	private JlTownWTService townWTService;
	@Autowired
	private JlTownXuKeService townXuKeService;
	private static final String NODATA = "nodata";
	private String cityCd;
	private String cityNm;
	private Integer currentPage;
	
	private JlTownWT townWT;

	public JlCityXuKeService getWaterXKService() {
		return waterXKService;
	}
	public void setWaterXKService(JlCityXuKeService waterXKService) {
		this.waterXKService = waterXKService;
	}
	public JlCityBService getCityBService() {
		return cityBService;
	}
	public void setCityBService(JlCityBService cityBService) {
		this.cityBService = cityBService;
	}
	public JlTownWTService getTownWTService() {
		return townWTService;
	}
	public void setTownWTService(JlTownWTService townWTService) {
		this.townWTService = townWTService;
	}
	public JlTownXuKeService getTownXuKeService() {
		return townXuKeService;
	}
	public void setTownXuKeService(JlTownXuKeService townXuKeService) {
		this.townXuKeService = townXuKeService;
	}
	public String getCityCd() {
		return cityCd;
	}
	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
	}
	public String getCityNm() {
		return cityNm;
	}
	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public JlTownWT getTownWT() {
		return townWT;
	}
	public void setTownWT(JlTownWT townWT) {
		this.townWT = townWT;
	}
	public String query() throws Exception {
		
		log.info("该用户查询了该年份的各地市年用水许可量");
		ActionContext context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		String hql="from JlCityXuKe w where year=2014";
		
		Page page=new Page();
		if(currentPage==null) {
			currentPage=1;
		}
		page.setCurrentPage(currentPage);
		page.setEveryPage(15);
		List<JlCityXuKe> waterWAList = waterXKService.find(hql, page.getBeginIndex(), page.getEveryPage());
		if(waterWAList!=null && waterWAList.size()>0) {
			int total=waterXKService.count(hql);
			page.setTotalCount(total);
			session.put("waterList", waterWAList);
			session.put("page", page);
			System.out.println(waterWAList);
			return SUCCESS;
		} else {
			return NODATA;
		}
	}
	
	public String toTransact(){
		ActionContext context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		JlCityB cityB = cityBService.findByCityCd(cityCd);
		session.put("cityB", cityB);
		System.out.println(cityB.cityCd+"toTransact");
		log.info("该用户打算对"+cityB.getCityNm()+"范围内的用水量进行了管理分配");

		return "water_transact";
	}
	
	public String doTransact() {
		System.out.println(townWT.getJlTownB1().getXiangCd()+"doTransact");
		System.out.println(townWT.getJlTownB2().getXiangCd()+"doTransact");
		System.out.println(townWT.getTW());
		
		ActionContext context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		
		String xiangCd1=townWT.getJlTownB1().getXiangCd();
		List<JlTownXuKe> townXKList1=townXuKeService.findByXiangCd(xiangCd1);	//转出方
		Iterator< JlTownXuKe> townXKIterator1=townXKList1.iterator();
		while(townXKIterator1.hasNext()) {
			JlTownXuKe townXuKe1=townXKIterator1.next();
			System.out.println(townXuKe1.getXukeW()+"转出之前");
			townXuKe1.setXukeW(townXuKe1.getXukeW()-townWT.getTW());
			System.out.println(townXuKe1.getXukeW()+"转出之后");
			session.put("townXuKe1", townXuKe1);
		}
		
		String xiangCd2=townWT.getJlTownB2().getXiangCd();
		
		log.info("进行水量分配调节的的是"+townWT.getJlTownB1().getXiangNm()+"->"+townWT.getJlTownB2().getXiangNm());
		List<JlTownXuKe> townXKList2=townXuKeService.findByXiangCd(xiangCd2);	//转入方
		Iterator< JlTownXuKe> townXKIterator2=townXKList2.iterator();
		while(townXKIterator2.hasNext()) {
			JlTownXuKe townXuKe2=townXKIterator2.next();
			townXuKe2.setXukeW(townXuKe2.getXukeW()-townWT.getTW());
			session.put("townXuKe2",townXuKe2);
		}
		session.put("townWT", townWT);
		townWTService.add(townWT);
		return "water_manage";
	}
}
