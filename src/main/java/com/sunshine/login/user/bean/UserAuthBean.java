/**
 * 
 */
package com.sunshine.login.user.bean;

import java.io.Serializable;

/**
 * 用户权限信息
 * 
 * @author sunshine
 */
public class UserAuthBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 权限编码
	 */
	private String authId;

	/*
	 * 权限名称
	 */
	private String authName;

	/*
	 * 菜单id
	 */
	private String menuId;

	/*
	 * 地址过滤状态
	 */
	private String urlStatus;

	/*
	 * 过滤地址
	 */
	private String url;

	/*
	 * 模块编码
	 */
	private String moduleId;

	public String getAuthId()
	{
		return authId;
	}

	public void setAuthId(String authId)
	{
		this.authId = authId;
	}

	public String getAuthName()
	{
		return authName;
	}

	public void setAuthName(String authName)
	{
		this.authName = authName;
	}

	public String getMenuId()
	{
		return menuId;
	}

	public void setMenuId(String menuId)
	{
		this.menuId = menuId;
	}

	public String getUrlStatus()
	{
		return urlStatus;
	}

	public void setUrlStatus(String urlStatus)
	{
		this.urlStatus = urlStatus;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

}
