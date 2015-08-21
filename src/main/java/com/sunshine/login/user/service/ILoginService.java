/**
 * 
 */
package com.sunshine.login.user.service;

import java.util.List;

import com.sunshine.login.user.bean.LeftMenuBean;
import com.sunshine.login.user.bean.TopModuleBean;
import com.sunshine.login.user.bean.UserInfoBean;
import com.sunshine.login.user.bean.UserRoleBean;

/**
 * 登陆服务
 * 
 * @author sunshine
 */
public interface ILoginService
{

	/**
	 * 根据用户 账户和密码 查询用户信息
	 * 
	 * @param userId
	 *            账户
	 * @param passwd
	 *            密码
	 * @return
	 */
	public UserInfoBean getUserInfo(String userId, String passwd);

	/**
	 * 查询用户角色和权限信息
	 * 
	 * @param roleId 角色编码
	 * @return
	 */
	public UserRoleBean getUserRole(String roleId);

	/**
	 * 根据用户权限信息，获取对应的顶部模块集合
	 * 
	 * @param userInfoBean 用户信息
	 * @return
	 */
	public List<TopModuleBean> getUserTopModule(UserInfoBean userInfoBean);

	/**
	 * 更新用户最后登录时间
	 * 
	 * @param userId 用户账号
	 */
	public void updateLastLogin(String userId);

	/**
	 * 根据模块编码和角色编码，查询该角色对应模块下的拥有权限的菜单信息
	 * 
	 * @param moduleId 模块编码
	 * @param roleId 角色编码
	 * @return
	 */
	public List<LeftMenuBean> qryLeftMenuList(String moduleId, String roleId);
}
