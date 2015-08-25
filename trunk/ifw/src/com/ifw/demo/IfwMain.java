package com.ifw.demo;
import java.util.HashMap;
import java.util.Map;

import com.ifw.base.IFWConstants;
import com.ifw.spring.ext.SpringFlow;

/**
 * ifw π”√demo
 * 
 * @author kfzx-xiezc
 *
 */
public class IfwMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Map model = new HashMap();
		SpringFlow so = new SpringFlow(model,"DemoFlow");
		so.execute();
		System.out.println("finish!the reply param that DemoFlow set is:" + model.get(IFWConstants.REPLY));
	}

}
