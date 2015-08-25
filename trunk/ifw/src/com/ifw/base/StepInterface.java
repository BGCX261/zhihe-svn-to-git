package com.ifw.base;

import java.util.HashMap;

import com.ifw.exception.EXTException;

public interface StepInterface {
	
	/**
	 * ִ�н��ײ�������
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
	 * ͨ�ÿ�ܲ���web�����󶨣��ϳ��˷���
	 * 
	 * @param paramName
	 * @return
	 */
	public void setSessionParam(String paramName, Object paramValue);
	/**
	 * @deprecated
	 * ͨ�ÿ�ܲ���web�����󶨣��ϳ��˷���
	 * 
	 * @param paramName
	 * @return
	 */
	public String getSessionStrParam(String paramName);
	/**
	 * @deprecated
	 * ͨ�ÿ�ܲ���web�����󶨣��ϳ��˷���
	 * 
	 * @param paramName
	 * @return
	 */
	public Object getSessionObjParam(String paramName);
	
}
