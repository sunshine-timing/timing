/**
 * 
 */
package com.sunshine.login.user.bean;

import java.io.Serializable;

/**
 * @author sunshine
 */
public class UserInfoBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;

	private String name;

	private String email;

	private String address;

	private String mobileNo;

	private String deptNo;

	private String roleId;

	private String lastLogin;

	private UserRoleBean userRoleBean;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getMobileNo()
	{
		return mobileNo;
	}

	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}

	public String getDeptNo()
	{
		return deptNo;
	}

	public void setDeptNo(String deptNo)
	{
		this.deptNo = deptNo;
	}

	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

	public String getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(String lastLogin)
	{
		this.lastLogin = lastLogin;
	}

	public UserRoleBean getUserRoleBean()
	{
		return userRoleBean;
	}

	public void setUserRoleBean(UserRoleBean userRoleBean)
	{
		this.userRoleBean = userRoleBean;
	}

}
