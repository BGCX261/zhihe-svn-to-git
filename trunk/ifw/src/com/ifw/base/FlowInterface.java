package com.ifw.base;

import java.util.Map;


import com.ifw.exception.EXTException;

public interface FlowInterface {
	
	public void execute() throws EXTException;
	
	public StepInterface getStepInstance(StepWraper sw) throws EXTException;
	
	public String getStringParam(String paramName);
	
	public Object getObjectParam(String paramName);
	
	public void setParameter(String paramName, Object paramValue);
	
	public void setFlowName(String flowName);
	
	public String getFlowName();
	
	public void setModel(Map s);
	
	public Map getModel();
	
	public FlowWraper getFlowWraper();

	public void setFlowWraper(FlowWraper flowWraper);
	
	public ServiceBean getService(String serviceID);
}
