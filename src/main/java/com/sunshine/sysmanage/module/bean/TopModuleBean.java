/**
 * 
 */
package com.sunshine.sysmanage.module.bean;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class TopModuleBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7403953726586262555L;

	/*
	 * 编码id
	 */
	private String id;

	/*
	 * 模块名称
	 */
	private String moduleName;

	/*
	 * 模块顺序
	 */
	private String moduleSort;

	/*
	 * 模块状态
	 */
	private String moduleStatus;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
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

	public String getModuleStatus()
	{
		return moduleStatus;
	}

	public void setModuleStatus(String moduleStatus)
	{
		this.moduleStatus = moduleStatus;
	}

}
