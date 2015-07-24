/**
 * 
 */
package com.sunshine.common.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

/**
 * @author lenovo
 */
public class LoginFilter extends StrutsPrepareAndExecuteFilter
{

	// 日志记录
	private static Logger logger = Logger.getLogger(LoginFilter.class);

	// 动态资源过滤
	private static final List<String> crossList = new ArrayList<String>();

	// 静态资源过滤
	private static final List<String> crossStyList = new ArrayList<String>();

	{
		Properties properties = new Properties();
		try
		{
			properties.load(getClass().getResourceAsStream("/crossType.properties"));
		} catch (FileNotFoundException e)
		{
			// e.printStackTrace();
			logger.error("加载登陆过滤文件失败：", e);
		} catch (IOException e)
		{
			// e.printStackTrace();
			logger.error("加载登陆过滤文件失败：", e);
		}

		// 装在动态资源过滤配置
		String crossDyList = properties.getProperty("crossDyList");
		String[] crossDyArr = crossDyList.split(",");
		for (int i = 0; i < crossDyArr.length; i++)
		{
			crossList.add(crossDyArr[i]);
		}

		// 装在静态资源过滤配置
		String crossStySet = properties.getProperty("crossStyList");
		String[] crossStyArr = crossStySet.split(",");
		for (int i = 0; i < crossStyArr.length; i++)
		{
			crossStyList.add(crossStyArr[i]);
		}

		/*
		 * crossList.add("/login.jsp"); crossList.add("/login.action");
		 * crossStyList.add(".js"); crossStyList.add(".css");
		 * crossStyList.add(".jpg"); crossStyList.add(".png");
		 * crossStyList.add(".gif");
		 */
	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
	        throws IOException, ServletException
	{

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		HttpSession session = request.getSession();

		// 请求地址
		String url = request.getServletPath();
		System.out.println("Filter url:" + url);

		// TODO
		//url = "/index.action";
		// 不带请求地址
		if (crossFilter(url) || session.getAttribute("userInfo") != null)
		{
			// 正常进行,进行xss过滤
			arg2.doFilter(new XssRequestWraper((HttpServletRequest) arg0), arg1);
			// arg2.doFilter(arg0, arg1);
		} else
		{
			response.sendRedirect("/index.jsp");
		}

	}

	/**
	 * 通过过滤的uri
	 * 
	 * @param str
	 * @return
	 */
	private boolean crossFilter(String str)
	{

		if (crossList.contains(str) || crossStyList.contains(str.substring(str.lastIndexOf("."), str.length())))
		{
			return true;
		} else
		{
			return false;
		}
	}

}
