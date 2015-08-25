package com.ifw.base;

import java.util.HashMap;

import com.ifw.exception.EXTException;

public interface StepInterface {
	
	/**
	 * 执行交易步骤内容
	 * */
	public String execute() throws EXTException;
	
	public void setStepID(String opStepID);
	
	public String getStepID();
	
	public String getStringParam(String paramName);
	
	public Object getObjectParam(String paramName);
	
	public void setStringParam(String paramName,String paramValue);
	
	public void setObjectParam(String paramName,Object paramValue);
	
	public void setFlow(FlowInterface flow);
	
	public FlowInterface getFlow();
	
	public HashMap getSettings();
	
	public String getSetting(String paramName);
	
	public ServiceBean getService(String serviceID);
	
	/**
	 * @deprecated
	 * 通用框架不与web开发绑定，废除此方法
	 * 
	 * @param paramName
	 * @return
	 */
	public void setSessionParam(String paramName, Object paramValue);
	/**
	 * @deprecated
	 * 通用框架不与web开发绑定，废除此方法
	 * 
	 * @param paramName
	 * @return
	 */
	public String getSessionStrParam(String paramName);
	/**
	 * @deprecated
	 * 通用框架不与web开发绑定，废除此方法
	 * 
	 * @param paramName
	 * @return
	 */
	public Object getSessionObjParam(String paramName);
	
}
