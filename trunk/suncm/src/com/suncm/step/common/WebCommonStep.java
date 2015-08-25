package com.suncm.step.common;

import javax.servlet.http.HttpSession;

import com.ifw.base.AbstractStep;

abstract public class WebCommonStep extends AbstractStep {

	/**
	 * ��дsession������ݵķ�����ר��web����
	 */
	public String getSessionStrParam(String paramName) {
		HttpSession session = (HttpSession)getObjectParam("ifw_session");
		return (String)session.getAttribute(paramName);
		
	}
	/**
	 * ��д��ö���ķ���
	 */
	public Object getSessionObjParam(String paramName) {
		HttpSession session = (HttpSession)getObjectParam("ifw_session");
		return session.getAttribute(paramName);
		
	}
	
	
	public void setSessionParam(String paramName, Object paramValue) {
		HttpSession session = (HttpSession)getObjectParam("ifw_session");
		session.setAttribute(paramName, paramValue);
	}
	

}
