/**
 * 
 */
package com.sunshine.login.user.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.sunshine.common.dao.IDaoSupport;
import com.sunshine.login.user.bean.UserInfoBean;
import com.sunshine.login.user.dao.ILoginDao;

/**
 * @author sunshine
 *
 */
public class LoginDaoImpl implements ILoginDao {

	/*
	 * 公共底层dao
	 */
	private IDaoSupport daoSupport;

	/**
	 * 查询用户信息
	 */
	@Override
	public UserInfoBean userLogin(String userid, String passwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("USERID", userid);
		map.put("PASSWD", passwd);
		return (UserInfoBean) daoSupport.query("userlogin.qryUser", map);
	}

	/*
	 * 获取公共底层dao
	 */
	public IDaoSupport getDaoSupport() {
		return daoSupport;
	}

	/*
	 * 设置公共底层dao
	 */
	public void setDaoSupport(IDaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

}
