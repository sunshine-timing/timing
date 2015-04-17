/**
 * 
 */
package com.sunshine.login.user.bean;

import java.io.Serializable;

/**
 * @author lenovo
 * 
 */
public class BaseUserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3414959648005684787L;

	/*
	 * 账户
	 */
	private String account;

	/*
	 * 用户名
	 */
	private String username;

	/*
	 * 年龄
	 */
	private String age;

	/*
	 * 性别
	 */
	private String gender;

	/*
	 * QQ号
	 */
	private String qq;

	/*
	 * 邮箱
	 */
	private String email;

	/*
	 * 描述
	 */
	private String desc;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
