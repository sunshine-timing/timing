/**
 * 
 */
package com.sunshine.login.user.bean;

import java.io.Serializable;

/**
 * 顶部模块信息
 * @author sunshine
 */
public class TopModuleBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 模块编码
	 */
	private String moduleId;

	/*
	 * 模块名称
	 */
	private String moduleName;

	/*
	 * 排序
	 */
	private String moduleSort;

	public String getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

	public String getModuleName()
	{
		return moduleName;
	}

	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	public String getModuleSort()
	{
		return moduleSort;
	}

	public void setModuleSort(String moduleSort)
	{
		this.moduleSort = moduleSort;
	}

}
