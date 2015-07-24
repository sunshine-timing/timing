/**
 * 
 */
package com.sunshine.login.user.dao;

import com.sunshine.login.user.bean.UserInfoBean;

/**
 * 登陆校验
 * 
 * @author sunshine
 *
 */
public interface ILoginDao {

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
}
