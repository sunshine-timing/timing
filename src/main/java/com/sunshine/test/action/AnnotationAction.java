package com.sunshine.test.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/anno")
@Result(location="/index.jsp")
public class AnnotationAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		System.out.println("annotation");
		return SUCCESS;
	}
}
