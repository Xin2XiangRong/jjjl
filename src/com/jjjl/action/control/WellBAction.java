package com.jjjl.action.control;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jjjl.data.JlExchWellB;
import com.jjjl.service.JlExchWellBService;
import com.jjjl.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("all")
@Controller
public class WellBAction extends ActionSupport {

	@Autowired
	private JlExchWellBService wellBService;
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
		
		log.info("该用户使用查用机井列表功能");
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
		
		log.info("该用户使用查询机电井详情功能");
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session=context.getSession();		
		if(wellCd!=null && !wellCd.equalsIgnoreCase("")){
			JlExchWellB wellDetail=wellBService.findByWellCd(wellCd);			
			if(wellDetail!=null){
				session.put("wellDetail", wellDetail);
				return SUCCESS;
			}else{
				return NODATA;
			}			
		}else{
			return NODATA;
		}		
	}
}
