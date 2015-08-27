/**
 * 
 */
package com.sunshine.login.user.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sunshine.login.user.bean.LeftMenuBean;
import com.sunshine.login.user.bean.LeftSubMenuBean;
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

		// 获取用户权限列表
		List<UserAuthBean> userAuthBeanList = userInfoBean.getUserRoleBean().getAuthList();

		String[] moduleIds = new String[userAuthBeanList.size()];

		// 获取权限模块编码
		for (int i = 0; i < moduleIds.length; i++)
		{
			moduleIds[i] = userAuthBeanList.get(i).getModuleId();
		}

		// 获取顶层模块
		List<TopModuleBean> topModuleBeans = dao.geTopModuleBeans(moduleIds);

		String roleId = userInfoBean.getRoleId();
		// 获取模块菜单
		for (TopModuleBean topModuleBean : topModuleBeans)
		{
			// 查询该模块下所有权限菜单
			List<LeftSubMenuBean> leftSubMenuBeans = qryLeftMenuList(topModuleBean.getModuleId(), roleId);
			// 菜单解析配置
			List<LeftMenuBean> leftMenuBeans = getLeftMenu(leftSubMenuBeans);

			// setter到对应的模块中去
			topModuleBean.setLeftMenuBeans(leftMenuBeans);

		}

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
	private List<LeftSubMenuBean> qryLeftMenuList(String moduleId, String roleId)
	{
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

	/**
	 * 将所有菜单进行封装成层级菜单
	 * 
	 * @param leftSubMenuBeans
	 * @return
	 */
	private List<LeftMenuBean> getLeftMenu(List<LeftSubMenuBean> leftSubMenuBeans)
	{
		List<LeftMenuBean> leftMenuBeans = new ArrayList<>();
		// 为空 则返回空
		if (leftSubMenuBeans == null)
		{
			return leftMenuBeans;
		}

		// 创建粗出
		Map<String, LeftMenuBean> result = new LinkedHashMap<String, LeftMenuBean>();
		// 循环遍历
		for (LeftSubMenuBean leftSubMenuBean : leftSubMenuBeans)
		{
			// 第一层子菜单,则将改菜单setter到map中
			if (leftSubMenuBean.getMenuClass().equals("0"))
			{
				LeftMenuBean leftTemp = new LeftMenuBean();
				leftTemp.setMenuId(leftSubMenuBean.getMenuId());
				leftTemp.setMenuName(leftSubMenuBean.getMenuName());
				leftTemp.setSubMenuBeans(new ArrayList<LeftSubMenuBean>());
				result.put(leftSubMenuBean.getMenuId(), leftTemp);
			}
			// 第二层子菜单
			else
			{
				// 从Map中获取对应的父菜单
				LeftMenuBean subTemp = result.get(leftSubMenuBean.getFatherMenu());
				if (subTemp == null)
				{
					continue;
				} else
				{
					// 放入第一层菜单的子菜单中
					subTemp.getSubMenuBeans().add(leftSubMenuBean);
				}
			}
		}

		// 迭代Map，将值取出返回
		for (Map.Entry<String, LeftMenuBean> entry : result.entrySet())
		{
			leftMenuBeans.add(entry.getValue());
		}

		return leftMenuBeans;
	}

}
