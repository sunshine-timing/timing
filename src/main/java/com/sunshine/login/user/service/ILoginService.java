/**
 * 
 */
package com.sunshine.login.user.service;

import com.sunshine.login.user.bean.UserInfoBean;

/**
 * 登陆服务
 * @author sunshine
 *
 */
public interface ILoginService {
	
	/**
	 * 根据用户 账户和密码 查询用户信息
	 * @param userId 账户
	 * @param passwd 密码
	 * @return
	 */
	public UserInfoBean getUserInfo(String userId,String passwd);
}
