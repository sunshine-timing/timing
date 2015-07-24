package com.sunshine.login.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sunshine.login.user.bean.UserInfoBean;
import com.sunshine.login.user.service.ILoginService;

public class LoginAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 日志记录
	 */
	private Logger logger = Logger.getLogger(LoginAction.class);

	/**
	 * 登录信息
	 */
	private String userid;

	/*
	 * 密码
	 */
	private String passwd;

	/**
	 * 登陆service服务
	 */
	private ILoginService service;

	public String login()
	{
		PrintWriter out = null;
		try
		{
			// 获取response对象，并设定字符集
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			logger.info("login action 获取：" + userid);
			System.out.println("*************************************************");
			// 账户或密码为空
			if (StringUtils.isBlank(userid) || StringUtils.isBlank(passwd))
			{
				out.write("empty");
			} else
			{
				UserInfoBean userInfoBean = service.getUserInfo(userid, passwd);
				// 登陆失败账户或密码错误
				if (null == userInfoBean)
				{
					out.write("error");
				} else
				{
					// 登陆状态记录到session中
					ServletActionContext.getRequest().getSession().setAttribute("userInfo", userInfoBean);
					out.write("success");
				}
			}

		} catch (IOException e)
		{
			// e.printStackTrace();
			logger.error("登陆账号密码校验异常：", e);
		} finally
		{
			if (null != out)
			{
				out.flush();
				out.close();
			}
		}
		return null;
	}

	/**
	 * 登陆管理主页面
	 * 
	 * @return
	 */
	public String Index()
	{
		// TODO:主页相关查询，角色菜单项，提醒，统计信息等
		return SUCCESS;
	}

	@Override
	public void validate()
	{
		// TODO Auto-generated method stub
		super.validate();
	}

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public String getPasswd()
	{
		return passwd;
	}

	public void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}

	public ILoginService getService()
	{
		return service;
	}

	public void setService(ILoginService service)
	{
		this.service = service;
	}

}
