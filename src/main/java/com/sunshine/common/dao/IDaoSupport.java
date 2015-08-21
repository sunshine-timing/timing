package com.sunshine.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class IDaoSupport
{

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

	/**
	 * 查询单挑记录
	 * 
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public Object query(String statement, Object parameter)
	{
		return this.sessionTemplate.selectOne(statement, parameter);
	}

	/**
	 * 返回查询的集合
	 * 
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public List<?> queryList(String statement, Object parameter)
	{
		return sessionTemplate.selectList(statement, parameter);
	}

	/**
	 * 更新数据
	 * 
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public int update(String statement, Object parameter)
	{
		return sessionTemplate.update(statement, parameter);
	}
}
