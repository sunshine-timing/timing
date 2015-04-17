/**
 * 
 */
package com.sunshine.common.regbean;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

import com.sunshine.test.bean.RegSpringBean;

/**
 * 利用配置文件 读取javabean注入到spring容器当中
 * 
 * @author lenovo
 * 
 */
public class SpringRegBean {

	public void reg() throws Exception {
		BeanFactory factory = getBeanFactory();
		RegSpringBean regBen = (RegSpringBean) factory.getBean("regtestBean");
	}

	/**
	 * 读取拓展文件
	 * 
	 * @return
	 * @throws Exception
	 */
	private BeanFactory getBeanFactory() throws Exception {
		// DefaultListableBeanFactory实现了 BeanFactory接口
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

		/*
		 * 创建一个用于读取Bean定义的阅读器，用于读取properties文件中的Bean定义
		 */
		PropertiesBeanDefinitionReader rdr = new PropertiesBeanDefinitionReader(
				factory);

		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"extension/springreg/regtest.properties"));

		rdr.registerBeanDefinitions(properties);

		return factory;
	}
}
