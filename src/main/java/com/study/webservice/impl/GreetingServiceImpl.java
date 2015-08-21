/**
 * 
 */
package com.study.webservice.impl;

import java.util.Calendar;

import javax.jws.WebService;

import com.study.webservice.Greeting;

/**
 * @author sunshine
 *
 */
@WebService(endpointInterface="com.study.webservice.Greeting")
public class GreetingServiceImpl implements Greeting
{

	/** 
	 * @see com.study.webservice.Greeting#greeting(java.lang.String)
	 * @param userName
	 * @return
	 */
	@Override
	public String greeting(String userName)
	{
		return "Hello "+ userName + " , currentTime is " + Calendar.getInstance().getTime();
	}

}
