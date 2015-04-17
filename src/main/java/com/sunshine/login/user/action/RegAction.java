/**
 * 
 */
package com.sunshine.login.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sunshine.login.user.bean.BaseUserBean;

/**
 * @author lenovo
 * 
 */
public class RegAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5848049355151360398L;

	/*
	 * 用户信息
	 */
	private BaseUserBean baseUserBean;

	/*
	 * 密码
	 */
	private String password1;

	/*
	 * 校验密码
	 */
	private String password2;

	/*
	 * 验证码
	 */
	private String validateCode;

	
	@Override
	public String execute() throws Exception {
		
		Thread.sleep(3000);
		
		return SUCCESS;
	}
	
	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public BaseUserBean getBaseUserBean() {
		return baseUserBean;
	}

	public void setBaseUserBean(BaseUserBean baseUserBean) {
		this.baseUserBean = baseUserBean;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

}
