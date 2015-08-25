package com.suncm.step.common;

import javax.servlet.http.HttpSession;

import com.ifw.base.AbstractStep;

abstract public class WebCommonStep extends AbstractStep {

	/**
	 * 重写session获得数据的方法，专用web开发
	 */
	public String getSessionStrParam(String paramName) {
		HttpSession session = (HttpSession)getObjectParam("ifw_session");
		return (String)session.getAttribute(paramName);
		
	}
	/**
	 * 重写获得对象的方法
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
