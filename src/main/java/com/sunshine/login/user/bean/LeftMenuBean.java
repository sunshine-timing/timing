/**
 * 
 */
package com.sunshine.login.user.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 左侧导航栏菜单
 * 
 * @author sunshine
 */
public class LeftMenuBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String menuId;

	private String menuName;

	private List<LeftSubMenuBean> subMenuBeans;

	/**
	 * @return the menuId
	 */
	public String getMenuId()
	{
		return menuId;
	}

	/**
	 * @param menuId
	 *            the menuId to set
	 */
	public void setMenuId(String menuId)
	{
		this.menuId = menuId;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName()
	{
		return menuName;
	}

	/**
	 * @param menuName
	 *            the menuName to set
	 */
	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}

	/**
	 * @return the subMenuBeans
	 */
	public List<LeftSubMenuBean> getSubMenuBeans()
	{
		return subMenuBeans;
	}

	/**
	 * @param subMenuBeans
	 *            the subMenuBeans to set
	 */
	public void setSubMenuBeans(List<LeftSubMenuBean> subMenuBeans)
	{
		this.subMenuBeans = subMenuBeans;
	}

}
