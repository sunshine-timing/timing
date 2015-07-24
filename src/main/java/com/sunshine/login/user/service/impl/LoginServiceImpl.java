/**
 * 
 */
package com.sunshine.login.user.service.impl;

import com.sunshine.login.user.bean.UserInfoBean;
import com.sunshine.login.user.dao.ILoginDao;
import com.sunshine.login.user.service.ILoginService;

/**
 * @author sunshine
 *
 */
public class LoginServiceImpl implements ILoginService {

	private ILoginDao dao;

	/**
	 * 查询用户信息
	 */
	@Override
	public UserInfoBean getUserInfo(String userId, String passwd) {
		return dao.userLogin(userId, passwd);
	}

	public ILoginDao getDao() {
		return dao;
	}

	public void setDao(ILoginDao dao) {
		this.dao = dao;
	}

}
