/**
 * 
 */
package com.sunshine.login.user.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 用户角色信息
 * 
 * @author sunshine
 */
public class UserRoleBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 角色编码
	 */
	private String roleId;

	/*
	 * 角色名称
	 */
	private String roleName;

	/*
	 * 角色权限信息
	 */
	private List<UserAuthBean> authList;

	
	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public List<UserAuthBean> getAuthList()
	{
		return authList;
	}

	public void setAuthList(List<UserAuthBean> authList)
	{
		this.authList = authList;
	}

}
