package com.sunshine.common.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class IDaoSupport {

	/**
	 * 引入mybatis的sessionTemplate
	 */
	SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() 
	{
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) 
	{
		this.sessionTemplate = sessionTemplate;
	}

}
