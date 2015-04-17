/**
 * 
 */
package com.sunshine.login.auth.bean;

import java.io.Serializable;

/**
 * @author lenovo
 *
 */
public class AuthorityInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 权限id
	 */
	private String authId;
	
	/**
	 * 权限名
	 */
	private String authName;
	
	/**
	 * 权限地址
	 */
	private String authUrl;
	
	/**
	 * 父级权限
	 */
	private String parentAuth;

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public String getParentAuth() {
		return parentAuth;
	}

	public void setParentAuth(String parentAuth) {
		this.parentAuth = parentAuth;
	}
	

}
