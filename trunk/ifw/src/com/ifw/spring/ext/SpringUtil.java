package com.ifw.spring.ext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext appContext = null;
	public static ApplicationContext getApplicationContext(){
		if(appContext == null){
    		appContext = new ClassPathXmlApplicationContext(
    		        new String[] {"config.xml"});
    	}
    	return appContext;
	}
}
