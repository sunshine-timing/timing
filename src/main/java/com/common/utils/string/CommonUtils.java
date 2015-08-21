/**
 * lenovo 2015-3-10
 */
package com.common.utils.string;


import java.util.UUID;


/**
 * 公共工具类
 * 
 * @author wangjianjian
 * 
 */
public class CommonUtils
{
	/**
	 * 使用jdk自带类生成的uuid，去掉中间的分隔符
	 * 
	 * @return uuid字符串（唯一标识）
	 */
	public static String getUUID()
	{
		String uuidStr = UUID.randomUUID().toString();
		String[] strArr = uuidStr.split("-");
		StringBuilder builder = new StringBuilder();
		for (String str : strArr)
		{
			builder.append(str);
		}
		return builder.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(getUUID());
	}

}
