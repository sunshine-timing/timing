/**
 * lenovo 2015-3-18
 */
package com.common.utils.encry;


import java.security.MessageDigest;

import org.apache.log4j.Logger;


/**
 * 
 * MD5工具类
 * 
 * @author wangjianjian
 * 
 */
public class MD5Util
{
	// 日志记录
	private static Logger	logger	= Logger.getLogger(MD5Util.class);

	/**
	 * 使用指定的编码格式，进行MD5加密
	 * 
	 * @param sourStr
	 *            需要加密的字符串
	 * @param char_set
	 *            编码格式
	 * @return MD5加密后的32位字符串
	 */
	public final static String MD5(String sourStr, String char_set)
	{

		logger.debug("sourStr=" + logger + ",char_set=" + char_set);

		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F'};
		try
		{
			byte[] btInput = sourStr.getBytes(char_set);
			// 获取MD5加密类
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 更新加密字符串
			mdInst.update(btInput);
			// 进行加密
			byte[] md = mdInst.digest();
			// 转换
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++)
			{
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}

			logger.debug("result[MD5UTIL]=" + new String(str));

			return new String(str);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 使用默认的utf-8编码，进行MD5加密
	 * 
	 * @param sourStr
	 *            需要加密的字符串
	 * @return md5加密后的32位字符串
	 */
	public static final String MD5(String sourStr)
	{
		return MD5(sourStr, "UTF-8");
	}
	
	public static void main(String[] args)
	{
		logger.debug("122222222222");
	}

}
