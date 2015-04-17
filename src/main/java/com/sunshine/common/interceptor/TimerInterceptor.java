/**
 * 
 */
package com.sunshine.common.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author lenovo
 *
 */
public class TimerInterceptor implements Interceptor {

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("interceptor___destroy");
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {
		System.out.println("interceptor___init");
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		
		ActionContext context = ActionContext.getContext();
		Map<String, Object> contextMap = context.getContextMap();
		System.out.println("*******interceptor********");
		System.out.println(contextMap.toString());
		System.out.println("***********staret*******");
		String result = arg0.invoke();
		System.out.println("**************end************");
		
		
		return result;
	}

}
