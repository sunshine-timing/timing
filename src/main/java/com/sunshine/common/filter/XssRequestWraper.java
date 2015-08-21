/**
 * 
 */
package com.sunshine.common.filter;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author lenovo
 * 
 */
public class XssRequestWraper extends HttpServletRequestWrapper {

	public XssRequestWraper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> paramMap = super.getParameterMap();
		Set<String> keySet = paramMap.keySet();
		// 迭代
		for (String str : keySet) {
			
		}
		return paramMap;
	}

	/**
	 * 将xss涉及到的文本做转换
	 * 
	 * @param str
	 * @return
	 */
	private String filterXss(String str) {
		return str;
	}

}
