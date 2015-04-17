package com.sunshine.login.user.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

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
	private String username;

	/*
	 * 密码
	 */
	private String password;

	/*
	 * 验证码
	 */
	private String validateCode;

	@Override
	public String execute() throws Exception {
		logger.debug("login starting");
		
		System.out.println("==============loginaction==============");
		logger.debug("login end");
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

}
