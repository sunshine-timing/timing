package com.sunshine.test.action;

import java.io.Serializable;

import org.apache.struts2.convention.annotation.Namespace;


import com.opensymphony.xwork2.ActionSupport;

@Namespace("/qrytest")
@org.apache.struts2.convention.annotation.Result(location="index.jsp")
public class TestAction extends ActionSupport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ����
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("******************TESTACTION*****************");
		
		return SUCCESS;
	}
	
	
	public String qrytest()
	{
		System.out.println("111111111");
		return SUCCESS;
	}

}
