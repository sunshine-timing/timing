/**
 * 
 */
package com.common.utils.encry;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.Base64;

/**
 * @author sunshine
 */
public class AESUtils
{

	/*
	 * 默认编码方式 utf-8
	 */
	private static final String CHARSET = "UTF-8";

	/*
	 * 加密的密码
	 */
	private static final String INIT_PASD = "1KD3diqDU32g4kd38jzdajD3ld73khc829cJd";

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static String encrypt(String content) throws NoSuchAlgorithmException, NoSuchPaddingException,
	        UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(INIT_PASD.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");// 创建密码器
		byte[] byteContent = content.getBytes(CHARSET);
		cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
		byte[] result = cipher.doFinal(byteContent);
		result = Base64.encode(result);
		return new String(result, CHARSET); // 加密
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static String decrypt(String contents) throws UnsupportedEncodingException, NoSuchAlgorithmException,
	        NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		byte[] content = contents.getBytes(CHARSET);
		content = Base64.decode(content);
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(INIT_PASD.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");// 创建密码器
		cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
		byte[] result = cipher.doFinal(content);
		return new String(result, CHARSET);
	}

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
	        UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException
	{
		String content = "12345678";
		// 加密
		System.out.println("加密前：" + content);
		String encryptResult = encrypt(content);
		System.out.println(encryptResult);

		// 解密
		String decryptResult = decrypt(encryptResult);
		System.out.println("解密后：" + decryptResult);
	}
}
