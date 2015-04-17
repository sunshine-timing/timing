/**
 * 
 */
package com.sunshine.login.user.bean;

/**
 * @author 繁空朔雪
 * 
 */
public class UserBean extends BaseUserBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2966500838033288265L;

	/*
	 * 最后登录时间
	 */
	private String last_login;

	/*
	 * 状态
	 */
	private String status;

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
