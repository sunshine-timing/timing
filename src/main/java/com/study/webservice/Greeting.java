/**
 * 
 */
package com.study.webservice;

import javax.jws.WebService;

/**
 * webservice 学习测试类（服务端接口）
 * @author sunshine
 *
 */
@WebService
public interface Greeting
{
	public String greeting(String userName);
}
