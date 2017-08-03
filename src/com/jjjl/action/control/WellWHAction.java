package com.jjjl.action.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jjjl.data.JlExchAutoWellB;
import com.jjjl.data.JlExchWellB;
import com.jjjl.data.WellBDayWV;
import com.jjjl.data.WellBMonthWV;
import com.jjjl.service.JlExchAutoWellBService;
import com.jjjl.service.JlExchWellBService;
import com.jjjl.service.WellBDayWVService;
import com.jjjl.service.WellBMonthWVService;
import com.jjjl.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("all")
@Controller
public class WellWHAction extends ActionSupport {

	@Autowired
	private JlExchWellBService wellBService;
	@Autowired
	private JlExchAutoWellBService autoWellBService;
	@Autowired
	private WellBDayWVService wellBDayWVService;
	@Autowired
	private WellBMonthWVService wellBMonthWVService;
	private static final String NODATA = "nodata";
	private static final String EDIT="edit";
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
	
	private JlExchWellB wellB=new JlExchWellB();
	private JlExchAutoWellB autoWellB=new JlExchAutoWellB();
	private WellBDayWV wellBDayWV=new WellBDayWV();
	private WellBMonthWV wellBMonthWV=new WellBMonthWV();
	
	public WellBDayWV getWellBDayWV() {
		return wellBDayWV;
	}
	public void setWellBDayWV(WellBDayWV wellBDayWV) {
		this.wellBDayWV = wellBDayWV;
	}
	public WellBMonthWV getWellBMonthWV() {
		return wellBMonthWV;
	}
	public void setWellBMonthWV(WellBMonthWV wellBMonthWV) {
		this.wellBMonthWV = wellBMonthWV;
	}
	public JlExchAutoWellB getAutoWellB() {
		return autoWellB;
	}
	public void setAutoWellB(JlExchAutoWellB autoWellB) {
		this.autoWellB = autoWellB;
	}
	public JlExchWellB getWellB() {
		return wellB;
	}
	public void setWellB(JlExchWellB wellB) {
		this.wellB = wellB;
	}
	public String getWellCd() {
		return wellCd;
	}
	public void setWellCd(String wellCd) {
		this.wellCd = wellCd;
	}
	public JlExchWellBService getWellBService() {
		return wellBService;
	}
	public void setWellBService(JlExchWellBService wellBService) {
		this.wellBService = wellBService;
	}
	public JlExchAutoWellBService getAutoWellBService() {
		return autoWellBService;
	}
	public void setAutoWellBService(JlExchAutoWellBService autoWellBService) {
		this.autoWellBService = autoWellBService;
	}
	public WellBDayWVService getWellBDayWVService() {
		return wellBDayWVService;
	}
	public void setWellBDayWVService(WellBDayWVService wellBDayWVService) {
		this.wellBDayWVService = wellBDayWVService;
	}
	public WellBMonthWVService getWellBMonthWVService() {
		return wellBMonthWVService;
	}
	public void setWellBMonthWVService(WellBMonthWVService wellBMonthWVService) {
		this.wellBMonthWVService = wellBMonthWVService;
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
	
	public String query()throws Exception{
		
		log.info("该用户打算机井数据进行维护");
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session=context.getSession();
		String  hql="from JlExchWellB b where 1=1 ";		
		if(xiangCd!=null && !xiangCd.equals("")){
			hql=hql+" and b.jlTownB.xiangCd like '"+xiangCd+"%'";
		}
		if(countyCd!=null && !countyCd.equals("")){
			hql=hql+" and b.jlTownB.xiangCd like '"+countyCd+"%'";
		}
		if(cityCd!=null && !cityCd.equals("")){
			hql=hql+" and b.jlTownB.xiangCd like '"+cityCd+"%'";
		}		
		if(p801004!=null && !p801004.equals("")){
			if(p801004.equals("1")){
				hql=hql+" and b.p801004 < 50 ";
			}
			if(p801004.equals("2")){
				hql=hql+" and b.p801004 >= 50 and b.p801004 <100";
			}
			if(p801004.equals("3")){
				hql=hql+" and b.p801004 >= 100 and b.p801004 <500";
			}
			if(p801004.equals("4")){
				hql=hql+" and b.p801004 >=500";
			}
		}
		if(p801011!=null && !p801011.equals("")){
			if(p801011.equals("1")){
				hql=hql+" and b.p801011 < 20 ";
			}
			if(p801011.equals("2")){
				hql=hql+" and b.p801011 >= 20 and b.p801011<50 ";
			}
			if(p801011.equals("3")){
				hql=hql+" and b.p801011 >= 50 and b.p801011<100 ";
			}
			if(p801011.equals("4")){
				hql=hql+" and b.p801011 >= 100 ";
			}
		}
		if(p801022!=null && !p801022.equals("")){
			hql=hql+" and b.p801022 = '"+p801022+"' ";
		}
		if(wellNm!=null && !wellNm.equals("")){
			hql=hql+" and b.wellNm like '%"+wellNm+"%'";
		}
		
		Page page=new Page();
		if(currentPage==null){
    		currentPage=1;
    	}
    	page.setCurrentPage(currentPage);
    	page.setEveryPage(15);    	
    	List<JlExchWellB> wellBlist =wellBService.find(hql, page.getBeginIndex(), page.getEveryPage());
		if(wellBlist!=null && wellBlist.size()>0){
			int total=wellBService.count(hql);
			page.setTotalCount(total);
    		session.put("wellBlist", wellBlist);
    		session.put("page", page);    		
    		return SUCCESS;
		}else{
			return NODATA;
		}	
	}
	
	public String detail()throws Exception{
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session=context.getSession();
		System.out.println("ddd"+wellCd);
		if(wellCd!=null && !wellCd.equalsIgnoreCase("")){
			JlExchWellB wellDetail=wellBService.findByWellCd(wellCd);			
			if(wellDetail!=null){
				session.put("wellDetail", wellDetail);
				return SUCCESS;
			}else{
				System.out.println("1111");
				return NODATA;
			}			
		}else{
			System.out.println("22222");
			return NODATA;
		}		
	}
	
	public String edit() throws Exception{
		ActionContext  context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		if(wellCd!=null && !wellCd.equalsIgnoreCase("")) {
			JlExchWellB wellEdit=wellBService.findByWellCd(wellCd);
			if(wellEdit!=null){
				System.out.println("11111");
				session.put("wellEdit", wellEdit);
				return EDIT;
			}else{
				System.out.println("222222");
				return NODATA;
			}
		}else{
			System.out.println("333333");
			return NODATA;
		}
	}
	
	public String update() throws Exception{
		/*ActionContext  context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();*/
		wellBService.update(wellB);
		System.out.println("update"+wellB.getWellNm());
		
		wellCd=wellB.getWellCd();
		
		log.info("该用户对"+wellB.getWellNm()+"的数据作了修改");
		return detail();
	}
	
	public String delete() throws Exception{
		wellB=wellBService.findByWellCd(wellCd);
		System.out.println("delete"+wellB.getWellNm());
		wellBService.delete(wellB);
		
		log.info("该用户删除了"+wellB.getWellNm());
		return query();
	}
	
	public String toWellAdd() throws Exception {
		
		return "well_add";
	}
	
	public String doWellAdd() throws Exception {
		System.out.println(wellB.getJlTownB()+"6666");
		xiangCd=wellB.getJlTownB().getXiangCd()+"";
		String  hql="from JlExchWellB b where  b.wellCd like '"+xiangCd+"%'";
		

		String iString="001";
		List<JlExchWellB> listWellB=wellBService.find(hql);
		if(listWellB!=null && listWellB.size()>0) {
		Iterator<JlExchWellB> wellITR=listWellB.iterator();
		int i=1;
		while(wellITR.hasNext()) {
			i++;
		}
		int j=1;
		while (i >= 10) {
	            //i 除以 10，自动忽略余数，再将结果赋值给i。  即：将i的末位数抹去。
	            i = i / 10;
	            //计数器自增
	            j++;
	    }
		if(j==1)
			iString="00"+i;
		if(j==2)
			iString="0"+i;
		if(j==3)
			iString=""+i;
		}
		wellCd=xiangCd+iString;
		System.out.println("666"+wellCd);
		wellB.setWellCd(wellCd);
		wellBService.addWell(wellB);
		
		log.info("该用户添加了"+wellB.getWellNm());
		return query();
	}
	
	public String toMonitor() throws Exception {
		ActionContext  context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		wellB=wellBService.findByWellCd(wellCd);
		session.put("wellEdit", wellB);
		log.info("该用户把"+wellB.getWellNm()+"设为了监测井");

		return "well_tomnt";
	}
	
	public String doMonitor() throws Exception{
		System.out.println(autoWellB.getWellCd()+"doMonitor");
		//System.out.println(autoWellB.getJlExchWellB()+"doMonitor");

		autoWellBService.addWell(autoWellB);
		
		wellBDayWV.setWellCd(autoWellB.getWellCd());
		wellBDayWVService.setDayW(wellBDayWV);
		
		wellBMonthWV.setWellCd(autoWellB.getWellCd());
		wellBMonthWVService.setMonthW(wellBMonthWV);
		
		//log.info("该用户把"+autoWellB.getJlExchWellB().getWellNm()+"设为了监测井");
		//System.out.println("doMonitor"+autoWellB.getJlExchWellB().getWellNm());
		//System.out.println("doMonitor"+wellB.getWellNm());
		return query();
	}
}
