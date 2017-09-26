package com.jjjl.action.control;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jjjl.data.SysUserB;
import com.jjjl.service.SysUserBService;
import com.jjjl.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
@Controller
public class SystemAction extends ActionSupport{
	
	private Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private SysUserBService userBService;
	private static final String NODATA = "nodata";
	
	private Integer currentPage;
	private SysUserB userB=new SysUserB();
	private String userid;
	
	public SysUserBService getUserBService() {
		return userBService;
	}
	public void setUserBService(SysUserBService userBService) {
		this.userBService = userBService;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public SysUserB getUserB() {
		return userB;
	}
	public void setUserB(SysUserB userB) {
		this.userB = userB;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String query() throws Exception {
		
		log.info("该用户查询了用户列表");
		ActionContext context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
		String hql="from SysUserB";
		Page page=new Page();
		if(currentPage==null) {
			currentPage=1;
		}
		page.setCurrentPage(currentPage);
		page.setEveryPage(15);
		List<SysUserB> userBList=userBService.find(hql, page.getBeginIndex(), page.getEveryPage());
		if(userBList!=null && userBList.size()>0) {
			int total=userBService.count(hql);
			page.setTotalCount(total);
			session.put("userBList", userBList);
			session.put("page",page);
			return SUCCESS;
		} else {
			return NODATA;
		}
	}
	
	public String delete() throws Exception {
		log.info("该用户删除了用户"+userB.getUserid());
		userB=userBService.queryByUserID(userid);
		log.info("该用户删除了用户"+userB.getUserid());
		System.out.println(userid+"userid");
		System.out.println("delete userB"+userB.getUsername());
		userBService.delete(userB);
		return query();
	}
	
	public String toUserAdd() throws Exception {
		return "user_add";
	}
	
	public String doUserAdd() throws Exception {
		log.info("该用户添加了用户"+userB.getUserid());
		userBService.save(userB);
		return query();
	}
	
	public void logInfo() throws IOException {
		/*Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));*/ 
		String stringPath="E:/logs/info.log";
		File file=new File(stringPath);
    	Desktop.getDesktop().open(file);
	}
}	

