package com.jjjl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.jjjl.data.SysUserB;

/**
 * @author Administrator
 * 定义用户是否登录，检测session中是否存在用户
 * 若用户存在，不做任何操作，不存在跳转到登录页面。
 *
 */
@SuppressWarnings("serial")
public class LoginFilter extends HttpServlet implements Filter {

	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String uriStr = request.getServletPath();
		HttpSession session = request.getSession(true);
		//获取session中的用户
		SysUserB user = (SysUserB) session.getAttribute("user");
		//获取请求的路径，如果不是用户登录页面，用户为空
		if (!uriStr.startsWith("/login.jsp") && user == null) {
			//获取请求的路径包含login.css，images，login.action时，放行		
			if (uriStr.endsWith("login.css") || uriStr.contains("images") || uriStr.contains("login.action")) {
				//放行
				arg2.doFilter(arg0, arg1);
			} else {
				//跳转到登录页面
				response.sendRedirect("/jjjl/login.jsp");
			}
        //不是用户登录页面，用户不为空，放行
		} else {
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
