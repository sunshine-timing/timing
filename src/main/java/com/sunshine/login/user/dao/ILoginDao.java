/**
 * 
 */
package com.sunshine.login.user.dao;

import java.util.List;

import com.sunshine.login.user.bean.LeftSubMenuBean;
import com.sunshine.login.user.bean.TopModuleBean;
import com.sunshine.login.user.bean.UserInfoBean;
import com.sunshine.login.user.bean.UserRoleBean;

/**
 * 登陆校验
 * 
 * @author sunshine
 */
public interface ILoginDao
{

	/**
	 * 根据用户账号和密码，查询账户信息，如果不匹配则返回null
	 * 
	 * @param userid
	 *            用户账户
	 * @param passwd
	 *            用户密码
	 * @return
	 */
	public UserInfoBean userLogin(String userid, String passwd);

	/**
	 * 根据角色id查询角色和权限信息
	 * 
	 * @param roleId
	 *            角色id
	 * @return
	 */
	public UserRoleBean getUserRole(String roleId);

	/**
	 * 根据权限数组获取对应的模块信息
	 * 
	 * @param moduleIds
	 * @return
	 */
	public List<TopModuleBean> geTopModuleBeans(String[] moduleIds);

	/***
	 * 更新用户最后登录时间
	 * 
	 * @param userId
	 */
	public void updateLastLogin(String userId);

	/**
	 * 根据用户角色和模块查询该模块下的菜单信息
	 * 
	 * @param moduleId
	 * @param roleId
	 * @return
	 */
	public List<LeftSubMenuBean> qryLeftMenu(String moduleId, String roleId);

}
