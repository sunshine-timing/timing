/**
 * 
 */
package com.sunshine.login.user.service.impl;

import java.util.List;

import com.sunshine.login.user.bean.LeftMenuBean;
import com.sunshine.login.user.bean.TopModuleBean;
import com.sunshine.login.user.bean.UserAuthBean;
import com.sunshine.login.user.bean.UserInfoBean;
import com.sunshine.login.user.bean.UserRoleBean;
import com.sunshine.login.user.dao.ILoginDao;
import com.sunshine.login.user.service.ILoginService;

/**
 * @author sunshine
 */
public class LoginServiceImpl implements ILoginService
{

	private ILoginDao dao;

	/**
	 * 查询用户信息
	 */
	@Override
	public UserInfoBean getUserInfo(String userId, String passwd)
	{
		return dao.userLogin(userId, passwd);
	}

	public ILoginDao getDao()
	{
		return dao;
	}

	public void setDao(ILoginDao dao)
	{
		this.dao = dao;
	}

	/**
	 * 查询用户角色和权限信息
	 * 
	 * @see com.sunshine.login.user.service.ILoginService#getUserRole(java.lang.String)
	 * @param roleId
	 * @return
	 */
	@Override
	public UserRoleBean getUserRole(String roleId)
	{
		return dao.getUserRole(roleId);
	}

	/**
	 * 根据用户信息（权限信息）获取对应的顶部模块信息
	 * 
	 * @see com.sunshine.login.user.service.ILoginService#getUserTopModule(com.sunshine.login.user.bean.UserInfoBean)
	 * @param userInfoBean
	 * @return
	 */
	@Override
	public List<TopModuleBean> getUserTopModule(UserInfoBean userInfoBean)
	{
		List<UserAuthBean> userAuthBeanList = userInfoBean.getUserRoleBean().getAuthList();

		String[] moduleIds = new String[userAuthBeanList.size()];

		for (int i = 0; i < moduleIds.length; i++)
		{
			moduleIds[i] = userAuthBeanList.get(i).getModuleId();
		}

		List<TopModuleBean> topModuleBeans = dao.geTopModuleBeans(moduleIds);

		return topModuleBeans;
	}

	/**
	 * 查询该角色拥有该模块下的菜单的信息
	 * 
	 * @see com.sunshine.login.user.service.ILoginService#qryLeftMenuList(java.lang.String,
	 *      java.lang.String)
	 * @param moduleId
	 *            模块编码
	 * @param roleId
	 *            角色编码
	 * @return
	 */
	@Override
	public List<LeftMenuBean> qryLeftMenuList(String moduleId, String roleId)
	{
		List<LeftMenuBean> ss = dao.qryLeftMenuXml(moduleId, roleId);
		System.out.println("****************************************************************************");
		System.out.println(ss);
		return dao.qryLeftMenu(moduleId, roleId);
	}

	/**
	 * 更新用户最后登录时间
	 * 
	 * @see com.sunshine.login.user.service.ILoginService#updateLastLogin(java.lang.String)
	 * @param userId
	 */
	@Override
	public void updateLastLogin(String userId)
	{
		dao.updateLastLogin(userId);
	}

}
