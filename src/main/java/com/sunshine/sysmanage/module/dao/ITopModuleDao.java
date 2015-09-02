/**
 * 
 */
package com.sunshine.sysmanage.module.dao;

import java.util.List;

import com.sunshine.sysmanage.module.bean.TopModuleBean;

/**
 * @author Administrator
 *
 */
public interface ITopModuleDao
{
	/**
	 * 查询所有模块信息
	 * 
	 * @return
	 */
	public List<TopModuleBean> getModules();
}
