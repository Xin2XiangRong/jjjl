package com.jjjl.action.sys;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jjjl.data.SysUserB;
import com.jjjl.service.SysUserBService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
@Controller
public class LoginAction extends ActionSupport {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";	
	private Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private SysUserBService sysUserBService;
	private SysUserB user;
	private String userid;
	private String password;	
	private String tip;
	
	public SysUserBService getSysUserBService() {
		return sysUserBService;
	}
	
	public void setSysUserBService(SysUserBService sysUserBService) {
		this.sysUserBService = sysUserBService;
	}
	public SysUserB getUser() {
		return user;
	}

	public void setUser(SysUserB user) {
		this.user = user;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		//userid="1";
		if(sysUserBService.validateByUserID(userid)){
			if(sysUserBService.validateByUserIDAndPassword(userid, password)){
				user=sysUserBService.queryByUserID(userid);
				session.put("user", user);
				log.info("用户"+user.getUsername()+"登陆");
				
				return SUCCESS;
			}else{				
				addActionError("密码错误,请重新输入密码");
				session.put("tip", tip);
				return FAIL;
			}
		}else{			
			addActionError("用户名错误,请重新输入用户名");
			session.put("tip", tip);
			return FAIL;
		}
		
	}
	
	/*public String toReset() throws Exception {
		System.out.println("1111+toReset()");
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		//userid="1";
		if(sysUserBService.validateByUserID(userid)){
			if(sysUserBService.validateByUserIDAndPassword(userid, password)){
				user=sysUserBService.queryByUserID(userid);
				session.put("user", user);
				log.info("用户"+user.getUsername()+"登陆");
				
				return SUCCESS;
			}else{				
				addActionError("密码错误,请重新输入密码");
				session.put("tip", tip);
				return FAIL;
			}
		}else{			
			addActionError("用户名错误,请重新输入用户名");
			session.put("tip", tip);
			return FAIL;
		}
		
	}

	public String doReset() throws Exception {
		sysUserBService.update(user);
		return SUCCESS;
	}*/
}
