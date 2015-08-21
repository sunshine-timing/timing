/**
 * 
 */
package com.sunshine.login.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sunshine.common.dao.IDaoSupport;
import com.sunshine.login.user.bean.LeftMenuBean;
import com.sunshine.login.user.bean.TopModuleBean;
import com.sunshine.login.user.bean.UserInfoBean;
import com.sunshine.login.user.bean.UserRoleBean;
import com.sunshine.login.user.dao.ILoginDao;

/**
 * @author sunshine
 */
public class LoginDaoImpl implements ILoginDao
{

	/*
	 * 公共底层dao
	 */
	private IDaoSupport daoSupport;

	/**
	 * 查询用户信息
	 */
	@Override
	public UserInfoBean userLogin(String userid, String passwd)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("USERID", userid);
		map.put("PASSWD", passwd);
		return (UserInfoBean) daoSupport.query("userlogin.qryUser", map);
	}

	/*
	 * 获取公共底层dao
	 */
	public IDaoSupport getDaoSupport()
	{
		return daoSupport;
	}

	/*
	 * 设置公共底层dao
	 */
	public void setDaoSupport(IDaoSupport daoSupport)
	{
		this.daoSupport = daoSupport;
	}

	/**
	 * 根据角色id查询角色和权限信息
	 * 
	 * @see com.sunshine.login.user.dao.ILoginDao#getUserRole(java.lang.String)
	 * @param roleId
	 * @return
	 */
	@Override
	public UserRoleBean getUserRole(String roleId)
	{
		return (UserRoleBean) daoSupport.query("userlogin.qryRoleInfo", roleId);
	}

	/**
	 * 查询用户的顶部模块列表
	 * 
	 * @see com.sunshine.login.user.dao.ILoginDao#geTopModuleBeans(java.lang.String[])
	 * @param moduleIds
	 * @return
	 */
	@Override
	public List<TopModuleBean> geTopModuleBeans(String[] moduleIds)
	{
		return (List<TopModuleBean>) daoSupport.queryList("userlogin.qryTopModules", moduleIds);
	}

	/**
	 * 更新用户最后登录的时间
	 * 
	 * @see com.sunshine.login.user.dao.ILoginDao#updateLastLogin(java.lang.String)
	 * @param userId
	 */
	@Override
	public void updateLastLogin(String userId)
	{
		daoSupport.update("userlogin.updateLastLogin", userId);
	}

	/**
	 * 根据模块编码和角色信息 查询该模块下角色拥有权限的菜单信息
	 * 
	 * @see com.sunshine.login.user.dao.ILoginDao#qryLeftMenu(java.lang.String,
	 *      java.lang.String)
	 * @param moduleId
	 * @param roleId
	 * @return
	 */
	@Override
	public List<LeftMenuBean> qryLeftMenu(String moduleId, String roleId)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("moduleId", moduleId);
		map.put("roleId", roleId);
		return (List<LeftMenuBean>) daoSupport.queryList("userlogin.qryLeftMenu", map);
	}

	@Override
	public List<LeftMenuBean> qryLeftMenuXml(String moduleId, String roleId)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("moduleId", moduleId);
		map.put("roleId", roleId);
		return (List<LeftMenuBean>) daoSupport.queryList("userlogin.qryLeftMenuJson", map);
	}
}
