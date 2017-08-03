package com.jjjl.action.control;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import z.json.JSONObject;

import com.jjjl.data.JlCityWA;
import com.jjjl.service.JlCityWAService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;
@SuppressWarnings("all")
@Controller
public class FenXiAction extends ActionSupport {

	private Logger log=Logger.getLogger(this.getClass());
	private static final String NODATA = "nodata";

	@Autowired
	private JlCityWAService jlCityWAService;
	
	private String cityCd;
	private String year;

	public JlCityWAService getJlCityWAService() {
		return jlCityWAService;
	}

	public void setJlCityWAService(JlCityWAService jlVityWAService) {
		this.jlCityWAService = jlVityWAService;
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
	
	public String analyseCity() throws Exception{
		
		log.info("该用户查看过行政区数据分析模块");
		ActionContext context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		if(cityCd!=null && !cityCd.equalsIgnoreCase("")) {
			List<JlCityWA> cityWA=jlCityWAService.findBycityCd(cityCd);		//按城市检索用来分析的数据
			
			if(cityWA!=null && cityWA.size()>0) {
				Iterator<JlCityWA> iteratorWA=cityWA.iterator();
				JSONArray jsonListWAT=new JSONArray();	//总用水量
				JSONArray jsonListWAF=new JSONArray();	//农业用水量
				JSONArray jsonListWAI=new JSONArray();	//工业用水量
				JSONArray jsonListWAL=new JSONArray();	//生活用水量
				JSONArray jsonListWAFP=new JSONArray();	//农业用水量占比
				JSONArray jsonListWAIP=new JSONArray();	//工业用水量占比
				JSONArray jsonListWALP=new JSONArray();	//生活用水量占比
				JSONArray jsonListHm = new JSONArray();	//最大信息熵值
				JSONArray jsonListH = new JSONArray();	//系统信息熵值
				//NumberFormat nt=NumberFormat.getPercentInstance();		//获取格式化对象
				//nt.setMinimumFractionDigits(2);		//设置百分数保留两位小数
				DecimalFormat df2 = new DecimalFormat("#0.00");
				DecimalFormat df3 = new DecimalFormat("#0.000");
				while(iteratorWA.hasNext()) {
					JlCityWA ajlCityWA=iteratorWA.next();
					List<String> alistWAT = new ArrayList<String>();
					JSONArray ajsonListWAT=new JSONArray();
					String year=ajlCityWA.getYear();	//获得年份
					Double tw=ajlCityWA.getTW();		//获得总用水量
					JSONArray jsonTW=JSONArray.fromObject(tw);
					alistWAT.add(year);
					alistWAT.addAll(jsonTW);
					ajsonListWAT=JSONArray.fromObject(alistWAT);
					jsonListWAT.add(ajsonListWAT);		//将转化为json的各分项汇总到一个json中
					
					List<String> alistWAF = new ArrayList<String>();
					JSONArray ajsonListWAF = new JSONArray();
					Double fw=ajlCityWA.getFW();		//获得农业用水量
					JSONArray jsonFW=JSONArray.fromObject(fw);
					alistWAF.add(year);
					alistWAF.addAll(jsonFW);
					ajsonListWAF=JSONArray.fromObject(alistWAF);
					jsonListWAF.add(ajsonListWAF);
					
					List<String> alistWAFP=new ArrayList<String>();
					JSONArray ajsonListWAFP = new JSONArray();
					Double ftp=fw/tw;	//获得农业用水占比
					JSONArray jsonFWP=JSONArray.fromObject(df2.parse(df2.format(ftp)));		
					alistWAFP.add(year);
					alistWAFP.addAll(jsonFWP);
					ajsonListWAFP=JSONArray.fromObject(alistWAFP);
					jsonListWAFP.add(ajsonListWAFP);
					
					List<String> alistWAI = new ArrayList<String>();
					JSONArray ajsonListWAI = new JSONArray();
					Double iw=ajlCityWA.getIW();		//获得工业用水量
					JSONArray jsonIW=JSONArray.fromObject(iw);
					alistWAI.add(year);
					alistWAI.addAll(jsonIW);
					ajsonListWAI=JSONArray.fromObject(alistWAI);
					jsonListWAI.add(ajsonListWAI);

					List<String> alistWAIP=new ArrayList<String>();
					JSONArray ajsonListWAIP = new JSONArray();
					Double itp=iw/tw;		//获得工业用水占比
					JSONArray jsonIWP=JSONArray.fromObject(df2.parse(df2.format(itp)));
					alistWAIP.add(year);
					alistWAIP.addAll(jsonIWP);
					ajsonListWAIP=JSONArray.fromObject(alistWAIP);
					jsonListWAIP.add(ajsonListWAIP);
					
					List<String> alistWAL = new ArrayList<String>();
					JSONArray ajsonListWAL = new JSONArray();
					Double lw=ajlCityWA.getLW();		//获得生活用水量
					JSONArray jsonLW=JSONArray.fromObject(lw);
					alistWAL.add(year);
					alistWAL.addAll(jsonLW);
					ajsonListWAL=JSONArray.fromObject(alistWAL);
					jsonListWAL.add(ajsonListWAL);
					
					List<String> alistWALP=new ArrayList<String>();
					JSONArray ajsonListWALP = new JSONArray();
					Double ltp=lw/tw;		//获得生活用水占比
					JSONArray jsonLWP=JSONArray.fromObject(df2.parse(df2.format(ltp)));
					alistWALP.add(year);
					alistWALP.addAll(jsonLWP);
					ajsonListWALP=JSONArray.fromObject(alistWALP);
					jsonListWALP.add(ajsonListWALP);
					
					/*计算最大信息熵值*/
					List<String> alistHm=new ArrayList<String>();
					JSONArray ajsonListHm = new JSONArray();
					Double hm=Math.log(3);
					JSONArray jsonHm = JSONArray.fromObject(df3.parse(df3.format(hm)));
					alistHm.add(year);
					alistHm.addAll(jsonHm);
					ajsonListHm=JSONArray.fromObject(alistHm);
					jsonListHm.add(ajsonListHm);
					
					/*计算系统信息熵值*/
					List<String> alistH = new ArrayList<String>();
					JSONArray ajsonListH = new JSONArray();
					Double h=-(ftp*Math.log(ftp)+itp*Math.log(itp)+ltp*Math.log(ltp));
					JSONArray jsonH = JSONArray.fromObject(df3.parse(df3.format(h)));
					alistH.add(year);
					alistH.addAll(jsonH);
					ajsonListH=JSONArray.fromObject(alistH);
					jsonListH.add(ajsonListH);
				}
				session.put("jsonListWAT", jsonListWAT);
				session.put("jsonListWAF", jsonListWAF);
				session.put("jsonListWAI", jsonListWAI);
				session.put("jsonListWAL", jsonListWAL);
				session.put("jsonListWAFP", jsonListWAFP);
				session.put("jsonListWAIP", jsonListWAIP);
				session.put("jsonListWALP", jsonListWALP);
				session.put("jsonListHm", jsonListHm);
				session.put("jsonListH", jsonListH);
				System.out.println("***jsonLiLtWAT****"+jsonListWAT);
				System.out.println("***jsonLiLtWAF****"+jsonListWAF);
				System.out.println("***jsonLiLtWAI****"+jsonListWAI);
				System.out.println("***jsonLiLtWAL****"+jsonListWAL);
				
				System.out.println("***jsonLiLtWAFP****"+jsonListWAFP);
				System.out.println("***jsonLiLtWAIP****"+jsonListWAIP);
				System.out.println("***jsonLiLtWALP****"+jsonListWALP);
				
				System.out.println("***jsonListHm****"+jsonListHm);
				System.out.println("***jsonListH****"+jsonListH);

			}
			if(cityWA!=null) {
				return SUCCESS;
			}else{
				return NODATA;
			}
		}else{
			return NODATA;
		}
		
	}
	
}
