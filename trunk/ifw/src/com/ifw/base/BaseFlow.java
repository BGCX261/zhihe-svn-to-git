package com.ifw.base;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifw.exception.EXTException;

public class BaseFlow implements FlowInterface {
	
	private Log log = LogFactory.getLog(BaseFlow.class);
	
	private Map model = null;
	
	private String flowName = null;
	
	private FlowWraper flowWraper = null;
	
	public BaseFlow(){
		super();
	}
	
	public BaseFlow(Map model,String flowName) throws IOException, EXTException{
		
		this.model = model;
		this.flowName = flowName;
		this.flowWraper = FlowWraperManager.getFlowWraper(flowName);
		
	}

	public void execute() throws EXTException {
		
		if(log.isDebugEnabled())
		log.debug("begin execute:" + flowName);
		
		String nextStep = flowWraper.getFirstOpStep();
	
		executeStep(nextStep);
		
		if(log.isDebugEnabled())
		log.debug("end execute:" + flowName);
	
	}
	/*递归执行OpStep*/
	private void executeStep(String nextStep) throws EXTException{
		
		StepWraper sw = (StepWraper)flowWraper.getOpSteps().get(nextStep);
		
		if(sw == null){
			throw new EXTException("flow run error,no such step:" + nextStep);
		}
		
		StepInterface osi = getStepInstance(sw);
		
		//执行OP返回结果
		String r = osi.execute();
		
		if(log.isDebugEnabled())
		log.debug("execute " + nextStep + ",the result is:" + r);
		
		nextStep = sw.getSwitch(r);
		
		
		if(nextStep.equals(IFWConstants.END)){
			
			return;
			
		}else{
			
			executeStep(nextStep);
			
		}
		
	}
	
	public StepInterface getStepInstance(StepWraper sw) throws EXTException {
		
		Class opStepClass = IFWConfigWraper.getOpStep(sw.getId());
		StepInterface os = null;
		try {
			os = (StepInterface) opStepClass.newInstance();
		} catch (IllegalAccessException e) {
			throw new EXTException("实例化" + opStepClass.getName() +"发生异常.",e);
		} catch (InstantiationException e) {
			throw new EXTException("实例化" + opStepClass.getName() +"发生异常.",e);
		}
		os.setStepID(sw.getStepDistId());
		os.setFlow(this);
		return os;	
	}
	
	public String getStringParam(String paramName) {
		
		if(this.model!=null){
			
			return (String)model.get(paramName);
			
		}else{
			
			return null;
			
		}
		
	}
	
	public Object getObjectParam(String paramName) {
		
		if(this.model!=null){
			
			return model.get(paramName);
			
		}else{
			
			return null;
			
		}
		
	}
	
	public void setParameter(String paramName, Object paramValue) {
		
		model.put(paramName, paramValue);
		
	}

	public String getFlowName() {
		
		return this.flowName;
		
	}

	public void setFlowName(String opName) {
		
		this.flowName = opName;
		
	}

	public Map getModel() {
		
		return model;
	}

	public void setModel(Map s) {
		
		model = s;
		
	}

	public FlowWraper getFlowWraper() {
		return flowWraper;
	}

	public void setFlowWraper(FlowWraper flowWraper) {
		this.flowWraper = flowWraper;
	}


	

	
	public ServiceBean getService(String serviceID) {
		
		return this.flowWraper.getServiceTable(serviceID);
	}
	
}
