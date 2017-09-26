package com.jjjl.action.control;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jjjl.data.JlCityWB;
import com.jjjl.data.JlCityXuKe;
import com.jjjl.service.JlCityWBService;
import com.jjjl.service.JlCityXuKeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("all")
@Controller
public class HuiZongAction extends ActionSupport {

	private Logger log=Logger.getLogger(this.getClass());
	private static final String NODATA = "nodata";

	@Autowired
	private JlCityXuKeService jlCityXuKeService;
	@Autowired
	private JlCityWBService jlCityWBService;
	
	private String cityCd;
	private String year;
	
	public JlCityXuKeService getJlCityXuKeService() {
		return jlCityXuKeService;
	}
	public void setJlCityXuKeService(JlCityXuKeService jlCityXuKeService) {
		this.jlCityXuKeService = jlCityXuKeService;
	}

	public JlCityWBService getJlCityWBService() {
		return jlCityWBService;
	}

	public void setJlCityWBService(JlCityWBService jlVityWBService) {
		this.jlCityWBService = jlVityWBService;
	}

	public String getCityCd() {
		return cityCd;
	}

	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String queryYear()throws Exception{
		log.info("该用户查询了行政区用水信息汇总（按年份）");
		ActionContext context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		if(year!=null && !year.equalsIgnoreCase("")) {
			List<JlCityXuKe> cityXuKeY=jlCityXuKeService.findByyear(year);	//按年份检索许可用水量、实际用水量
			List<JlCityWB> cityWBY=jlCityWBService.findByyear(year);
			
			if(cityXuKeY!=null && cityXuKeY.size()>0){
				Iterator<JlCityXuKe> iteratorXKY=cityXuKeY.iterator();
				JSONArray jsonListXKY=new JSONArray();
				while(iteratorXKY.hasNext()){
					List<String> alistXKY=new ArrayList<String>();
					JSONArray ajsonListXKY=new JSONArray();
					JlCityXuKe ajlCityXuKe=iteratorXKY.next();
					String nm=ajlCityXuKe.getJlCityB().getCityNm();		//获得城市名称
					Double xukeW=ajlCityXuKe.getXukeW();		//获得许可用水量
					JSONArray jsonXukeW=JSONArray.fromObject(xukeW);
					alistXKY.add(nm);
					alistXKY.addAll(jsonXukeW);
					ajsonListXKY=JSONArray.fromObject(alistXKY);
					jsonListXKY.add(ajsonListXKY);		//将转化为json的各分项汇总到一个json中
				}
				session.put("jsonListXKY", jsonListXKY);
				System.out.println("***jsonListXKY****"+jsonListXKY);
				session.put("cityXuKeY", cityXuKeY);
			}
			if(cityWBY!=null && cityWBY.size()>0) {
				Iterator<JlCityWB> iteratorWBY=cityWBY.iterator();
				JSONArray jsonListWBY=new JSONArray();
				while(iteratorWBY.hasNext()) {
					List<String> alistWBY = new ArrayList<String>();
					JSONArray ajsonListWBY=new JSONArray();
					JlCityWB ajlCityWB=iteratorWBY.next();
					String nm=ajlCityWB.getJlCityB().getCityNm();	//获得城市名称
					Double pw=ajlCityWB.getPW();		//获得上报用水量
					JSONArray jsonPW=JSONArray.fromObject(pw);
					alistWBY.add(nm);
					alistWBY.addAll(jsonPW);
					ajsonListWBY=JSONArray.fromObject(alistWBY);
					jsonListWBY.add(ajsonListWBY);		//将转化为json的各分项汇总到一个json中
				}
				session.put("jsonListWBY", jsonListWBY);
				System.out.println("***jsonListWBY****"+jsonListWBY);
				session.put("cityWBY",cityWBY);
			}
			if(cityXuKeY!=null && cityWBY!=null){
				return SUCCESS;
			}else{
				return NODATA;
			}
		}else{
			return NODATA;
		}
		
	}
	public String queryCity() throws Exception{
		
		log.info("该用户查询了行政区用水信息汇总（按地市）");
		ActionContext context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		if(cityCd!=null && !cityCd.equalsIgnoreCase("")) {
			List<JlCityXuKe> cityXuKeD=jlCityXuKeService.findBycityCd(cityCd);		//按城市检索许可用水量、实际用水量
			List<JlCityWB> cityWBD=jlCityWBService.findBycityCd(cityCd);
			
			if(cityXuKeD!=null && cityXuKeD.size()>0){
				Iterator<JlCityXuKe> iteratorXKD=cityXuKeD.iterator();
				JSONArray jsonListXKD=new JSONArray();
				while(iteratorXKD.hasNext()){
					List<String> alistXKD=new ArrayList<String>();
					JSONArray ajsonListXKD=new JSONArray();
					JlCityXuKe ajlCityXuKe=iteratorXKD.next();
					String year=ajlCityXuKe.getYear();		//获得年份
					Double xukeW=ajlCityXuKe.getXukeW();		//获得许可用水量
					JSONArray jsonXukeW=JSONArray.fromObject(xukeW);
					alistXKD.add(year);
					alistXKD.addAll(jsonXukeW);
					ajsonListXKD=JSONArray.fromObject(alistXKD);
					jsonListXKD.add(ajsonListXKD);		//将转化为json的各分项汇总到一个json中
				}
				session.put("jsonListXKD", jsonListXKD);
				System.out.println("***jsonListXKY****"+jsonListXKD);
				session.put("cityXuKeD", cityXuKeD);
			}
			if(cityWBD!=null && cityWBD.size()>0) {
				Iterator<JlCityWB> iteratorWBD=cityWBD.iterator();
				JSONArray jsonListWBD=new JSONArray();
				while(iteratorWBD.hasNext()) {
					List<String> alistWBD = new ArrayList<String>();
					JSONArray ajsonListWBD=new JSONArray();
					JlCityWB ajlCityWB=iteratorWBD.next();
					String year=ajlCityWB.getYear();	//获得年份
					Double pw=ajlCityWB.getPW();		//获得上报用水量
					JSONArray jsonPW=JSONArray.fromObject(pw);
					alistWBD.add(year);
					alistWBD.addAll(jsonPW);
					ajsonListWBD=JSONArray.fromObject(alistWBD);
					jsonListWBD.add(ajsonListWBD);		//将转化为json的各分项汇总到一个json中
				}
				session.put("jsonListWBD", jsonListWBD);
				System.out.println("***jsonListWBY****"+jsonListWBD);
				session.put("cityWBD",cityWBD);
			}
			if(cityXuKeD!=null && cityWBD!=null) {
				return SUCCESS;
			}else{
				return NODATA;
			}
		}else{
			return NODATA;
		}
		
	}
	
}
