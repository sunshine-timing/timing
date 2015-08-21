/**
 * 
 */
package com.sunshine.login.user.bean;

import java.io.Serializable;

/**
 * 左侧菜单导航栏子菜单
 * 
 * @author sunshine
 */
public class LeftSubMenuBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 菜单编码
	 */
	private String menuId;

	/*
	 * 菜单地址
	 */
	private String menuUrl;

	/*
	 * 菜单名称
	 */
	private String menuName;

	public String getMenuId()
	{
		return menuId;
	}

	public void setMenuId(String menuId)
	{
		this.menuId = menuId;
	}

	public String getMenuUrl()
	{
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl)
	{
		this.menuUrl = menuUrl;
	}

	public String getMenuName()
	{
		return menuName;
	}

	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}

}
