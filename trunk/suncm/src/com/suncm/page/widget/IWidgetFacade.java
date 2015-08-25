package com.suncm.page.widget;

import com.suncm.pojo.SuncmProcatePageset;

/**
 * 页面配置最终会转化为页面的代码，此接口定义了由页面配置得到各种页面代码的若干方法
 * 可理解为SuncmProcatePageset的包装类
 * 
 * @author kfzx-xiezc
 *
 */
public interface IWidgetFacade {
	/**
	 * 获得输入项code
	 * @return
	 */
	public String getInputCode();
	/**
	 * 获得输出code
	 * @return
	 */
	public String getDispCode();
	
}
