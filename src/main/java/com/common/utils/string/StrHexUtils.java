/**
 * lenovo 2015-3-18
 */
package com.common.utils.string;


import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;


/**
 * 字符串与16进制相互转换工具类
 * 
 * @author lenovo
 * 
 */
public class StrHexUtils
{
	private static String	hexString	= "0123456789ABCDEF";


	/**
	 * 采用指定的编码格式，将字符串转换为16进制
	 * 
	 * @param str
	 *            需要转换到字符串
	 * @param char_set
	 *            　编码格式
	 * @return 转换后的16进制字符串
	 */
	public static String strToHex(String str, String char_set)
	{
		byte[] bytes = null;
		try
		{
			bytes = str.getBytes(char_set);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++)
		{
			sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
			sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
		}
		return sb.toString();
	}


	/**
	 * 采用默认gbk的形式将字符串转换为16进制
	 * 
	 * @param str
	 *            需要转换的字符串
	 * @return 转换后的16进制编码
	 */
	public static String strToHex(String str)
	{
		return strToHex(str, "GBK");
	}


	/**
	 * 采用指定编码方式，将16进制转换为字符串
	 * 
	 * @param bytes
	 *            16进制字符串
	 * @param char_set
	 *            编码方式
	 * @return 转换后的原始字符串
	 */
	public static String hexToStr(String bytes, String char_set)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
		for (int i = 0; i < bytes.length(); i += 2)
			baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
		try
		{
			return new String(baos.toByteArray(), char_set);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		return null;
	}


	/**
	 * 采用默认的gbk方式，将16进制转换为字符串
	 * 
	 * param hexStr 16进制字符串
	 * 
	 * @return 换换后的原始字符串
	 */
	public static String hex2Str(String hexStr)
	{
		return hexToStr(hexStr, "GBK");
	}
}
