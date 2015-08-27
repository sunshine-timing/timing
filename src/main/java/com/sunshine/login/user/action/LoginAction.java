package com.sunshine.login.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.common.utils.encry.AESUtils;
import com.common.utils.encry.RSAUtils;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.sunshine.login.user.bean.TopModuleBean;
import com.sunshine.login.user.bean.UserInfoBean;
import com.sunshine.login.user.bean.UserRoleBean;
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

	/*
	 * request
	 */
	HttpServletRequest request;

	/*
	 * response
	 */
	HttpServletResponse response;

	/**
	 * 登陆请求 校验密码
	 * 
	 * @return
	 */
	public String login()
	{
		PrintWriter out = null;
		try
		{
			// 获取response对象，并设定字符集
			getRequest().setCharacterEncoding("UTF-8");
			out = getResponse().getWriter();
			logger.info("login action 获取：" + userid + ";passwd:" + passwd);
			passwd = RSAUtils.decryptStringByJs(passwd);
			logger.debug("passwd解密后：" + passwd);
			// 账户或密码为空
			if (StringUtils.isBlank(userid) || StringUtils.isBlank(passwd))
			{
				out.write("empty");
			} else
			{
				UserInfoBean userInfoBean = service.getUserInfo(userid, AESUtils.encrypt(passwd));
				// 登陆失败账户或密码错误
				if (null == userInfoBean)
				{
					out.write("error");
				} else
				{
					// 登陆状态记录到session中
					ServletActionContext.getRequest().getSession().setAttribute("userInfo", userInfoBean);
					// 更新最后登录时间
					service.updateLastLogin(userid);
					out.write("success");
				}
			}

		} catch (IOException e)
		{
			logger.error("登陆账号密码校验异常：", e);
		} catch (Exception e)
		{
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
	 * 查询用户角色权限以及页面初始化相关
	 * 
	 * @return
	 */
	public String index()
	{
		// TODO:主页相关查询，角色菜单项，提醒，统计信息等

		// 获取权限信息
		logger.debug("index.action===");
		UserInfoBean userInfoBean = (UserInfoBean) ServletActionContext.getRequest().getSession()
				.getAttribute("userInfo");
		logger.debug("index.user role id=" + userInfoBean.getRoleId());
		UserRoleBean userRoleBean = service.getUserRole(userInfoBean.getRoleId());
		userInfoBean.setUserRoleBean(userRoleBean);

		// 缓存顶部菜单
		List<TopModuleBean> topModuleBeans = service.getUserTopModule(userInfoBean);
		logger.debug("topModuleBeans.size:" + topModuleBeans.size());
		ServletActionContext.getRequest().getSession().setAttribute("topModules", topModuleBeans);

		return SUCCESS;
	}

	/**
	 * 获取登陆的加密key
	 * 
	 * @return
	 */
	public String pubKey()
	{
		logger.debug("start get keypair....");
		RSAPublicKey publicKey = RSAUtils.getDefaultPublicKey();
		PrintWriter out = null;
		try
		{
			logger.debug("start get pubkey....");
			// 获取response对象，并设定字符集
			getResponse().setCharacterEncoding("UTF-8");
			out = getResponse().getWriter();
			Map<String, String> map = new HashMap<String, String>();
			map.put("modulus", new String(Hex.encodeHex(publicKey.getModulus().toByteArray())));
			map.put("exponent", new String(Hex.encodeHex(publicKey.getPublicExponent().toByteArray())));
			logger.debug("object to json");
			Gson gson = new Gson();
			out.write(gson.toJson(map));
			logger.debug("write json end");

		} catch (IOException e)
		{
			// e.printStackTrace();
			logger.error("登陆加密公钥获取失败：", e);
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
	 * 筛选对应子菜单
	 * 
	 * @return
	 */
	public String leftMenu()
	{
		String moduleId = getRequest().getParameter("moduleId");
		@SuppressWarnings("unchecked")
		List<TopModuleBean> topModuleBeans = (List<TopModuleBean>) ServletActionContext.getRequest().getSession()
				.getAttribute("topModules");
		for (TopModuleBean topModuleBean : topModuleBeans)
		{
			if (topModuleBean.getModuleId().equals(moduleId))
			{
				getRequest().setAttribute("leftMenuBeans", topModuleBean.getLeftMenuBeans());
				break;
			}
		}
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

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}

}
