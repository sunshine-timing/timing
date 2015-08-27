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

	/*
	 * 菜单层级
	 */
	private String menuClass;

	/*
	 * 父菜单编码
	 */
	private String fatherMenu;

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

	/**
	 * @return the menuClass
	 */
	public String getMenuClass()
	{
		return menuClass;
	}

	/**
	 * @param menuClass
	 *            the menuClass to set
	 */
	public void setMenuClass(String menuClass)
	{
		this.menuClass = menuClass;
	}

	/**
	 * @return the fatherMenu
	 */
	public String getFatherMenu()
	{
		return fatherMenu;
	}

	/**
	 * @param fatherMenu
	 *            the fatherMenu to set
	 */
	public void setFatherMenu(String fatherMenu)
	{
		this.fatherMenu = fatherMenu;
	}

}
