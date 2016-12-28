/*
 * <b>文件名</b>：UserTools.java
 *
 * 文件描述：
 *
 *
 * 2014年9月9日  上午11:41:01
 */
package com.neil.base;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;





/**
 * <p> Title: 9fBank-蜡笔畅学 获取session 信息</p>
 * <p> Description: Intelligent Camp Monitoring System </p>
 * <p> Copyright: Copyright (c) 2014 </p>
 * <p> Company: http://www.labifenqi.com </p> 
 * @author xixing
 * @version 1.0
 * @date  2015-5-21 上午11:16:41
 */
public class SpringContextHolder {
	
	/**
	 * @方法名：ServletRequestAttributes
	 * @功能说明：获取RequestAttributes
	 * @author xixing
	 * @date  2015-5-21 上午11:16:41
	 * @return ServletRequestAttributes
	 */
	public static ServletRequestAttributes getSrAttrs() {
		ServletRequestAttributes srAttrs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return srAttrs;
	}
	
	/**
	 * @方法名：getRequest
	 * @功能说明：获取Request
	 * @author xixing
	 * @date  2015-5-21 上午11:16:41
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		return getSrAttrs().getRequest();
	}
	
	/**
	 * @方法名：getSession
	 * @功能说明：获取Session
	 * @author xixing
	 * @date  2015-5-21 上午11:16:41
	 * @return HttpSession
	 */
	public static HttpSession getSession() {
		return getSrAttrs().getRequest().getSession();
	}
	
	
	

	
	
	/**
	 * @方法名：getWebApplicationContext
	 * @功能说明：取得webApplicationContext
	 * @author xixing
	 * @date  2014年11月25日 下午4:29:27
	 * @return
	 */
	public static WebApplicationContext getWebApplicationContext() {
		ServletContext servletContext = getSession().getServletContext();
		return WebApplicationContextUtils.getWebApplicationContext(servletContext);
	}
	
	/**
	 * @方法名：getParameter
	 * @功能说明：根据Requet取得参数
	 * @param paramName
	 * @return
	 * @author xixing
	 * @date  2015年5月4日 下午3:27:22
	 */
	public static String getParameter(String paramName) {
		return getSrAttrs().getRequest().getParameter(paramName);
	}
}
