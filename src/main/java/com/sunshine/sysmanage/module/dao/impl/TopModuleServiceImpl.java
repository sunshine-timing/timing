/**
 * 
 */
package com.sunshine.sysmanage.module.dao.impl;

import java.util.List;

import com.sunshine.common.dao.IDaoSupport;
import com.sunshine.sysmanage.module.bean.TopModuleBean;
import com.sunshine.sysmanage.module.dao.ITopModuleDao;

/**
 * @author Administrator
 *
 */
public class TopModuleServiceImpl implements ITopModuleDao
{
	/*
	 * 公共底层dao
	 */
	private IDaoSupport daoSupport;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunshine.sysmanage.module.dao.ITopModuleDao#getModules()
	 */
	@Override
	public List<TopModuleBean> getModules()
	{
		daoSupport.queryList("", null);
		return null;
	}

}
