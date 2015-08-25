package com.ifw.base;

import java.util.HashMap;

public class StepWraper {
	
	String id = null;
	String stepDistId = null;//step的唯一标志
	public String getStepDistId() {
		return stepDistId;
	}

	public void setStepDistId(String stepDistId) {
		this.stepDistId = stepDistId;
	}

	HashMap attributes = null;
	HashMap switchMap = null;
	
	public StepWraper(String opStepID,String aStepDistId){
		
		id = opStepID;
		stepDistId = aStepDistId;
		attributes = new HashMap();
		switchMap = new HashMap();
		
	}

	public HashMap getAttributes() {
		
		return attributes;
		
	}

	public void setAttributes(HashMap attributes) {
		
		this.attributes = attributes;
		
	}

	public String getId() {
		
		return id;
		
	}

	public void setId(String id) {
		
		this.id = id;
		
	}

	public HashMap getSwitchMap() {
		
		return switchMap;
		
	}

	public void setSwitchMap(HashMap switchMap) {
		
		this.switchMap = switchMap;
		
	}
	
	public String getAttribute(String attrName){
		
		if(attributes!=null)
			
			return (String)attributes.get(attrName);
		
		else
			
			return null;

	}
	
	public void setAttribute(String attrName,String attrValue){
		
		if(attributes!=null)
			
			attributes.put(attrName, attrValue);

	}
	
	public String getSwitch(String resultSign){
		
		if(switchMap!=null)
			
			return (String)switchMap.get(resultSign);
		
		else
			
			return null;

	}
	 
	public void setSwitch(String resultSign,String opStep){
		
		if(switchMap!=null)
			
			switchMap.put(resultSign, opStep);

	}

}
