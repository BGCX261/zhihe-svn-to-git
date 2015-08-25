package com.ifw.base;
 
import java.util.HashMap;


abstract public class AbstractStep implements StepInterface {
	
	//public final Log log = LogFactory.getLogFactory().getLog(IFWConstants.IFWLOG);
	
	private String opStepID;
	
	private FlowInterface op;

	public AbstractStep(){
		
		super();
		
	}
	
	public void setStepID(String opStepID){
		
		this.opStepID = opStepID;
		
	}
	
	public String getStepID(){
		
		return opStepID;
		
	}
	
	public String getStringParam(String paramName){
		
		return (String)op.getStringParam(paramName);
		
	}
	
	public Object getObjectParam(String paramName){
		
		return op.getObjectParam(paramName);
		
	}
	
	public void setStringParam(String paramName,String paramValue){
		op.setParameter(paramName, paramValue);
	}
	
	public void setObjectParam(String paramName,Object paramValue){
		
		op.setParameter(paramName, paramValue);
		
	}
	/**
	 * @deprecated
	 * 通用框架不与web开发绑定，使用op通用方法实现
	 * 
	 * @param paramName
	 * @return
	 */
	public void setSessionParam(String paramName, Object paramValue){
		op.setParameter(paramName, paramValue);
	}
	/**
	 * @deprecated
	 * 通用框架不与web开发绑定，使用op通用方法实现
	 * 
	 * @param paramName
	 * @return
	 */
	public String getSessionStrParam(String paramName){
		return op.getStringParam(paramName);
	}
	/**
	 * @deprecated
	 * 通用框架不与web开发绑定，使用op通用方法实现
	 * 
	 * @param paramName
	 * @return
	 */
	public Object getSessionObjParam(String paramName){
		return op.getObjectParam(paramName);
	}
	
	public FlowInterface getFlow(){
			
		return op;
	
	}
	
	public void setFlow(FlowInterface op){
		
		this.op = op;
		
	}
	
	public HashMap getSettings(){
		
		StepWraper ow = (StepWraper)op.getFlowWraper().getOpSteps().get(this.opStepID);
		
		return ow.getAttributes();
		
	}
	
	public String getSetting(String paramName){
		Object obj = getSettings().get(paramName);
		return obj!=null?(String)obj:null;
	}
	
	public ServiceBean getService(String serviceID){
		return this.op.getService(serviceID);
	}

}
